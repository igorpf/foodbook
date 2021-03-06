package br.ufrgs.foodbook.controller;

import br.ufrgs.foodbook.dto.group.GroupInformationData;
import br.ufrgs.foodbook.dto.group.GroupRegistrationData;
import br.ufrgs.foodbook.service.GroupService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Set;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/secured/group")
public class GroupController extends AbstractGenericController
{
    @Resource
    GroupService groupService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity createGroup(@RequestBody GroupRegistrationData groupRegistrationData, Principal principal)
    {
        groupRegistrationData.setCreatorName(principal.getName());
        groupService.create(groupRegistrationData);
        return new ResponseEntity(CREATED);
    }

    @GetMapping(value = "/{groupId}")
    @ResponseStatus(value = HttpStatus.OK)
    public GroupInformationData getGroupInformation(@PathVariable("groupId") String groupId)
    {
        return groupService.getGroup(Long.valueOf(groupId));
    }

    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity updateGroup(@RequestBody GroupRegistrationData groupUpdateRequestData, Principal principal)
    {
        groupUpdateRequestData.setCreatorName(principal.getName());
        groupService.update(groupUpdateRequestData);
        return new ResponseEntity(OK);
    }

    @DeleteMapping(value = "/remove")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity removeGroup(@RequestBody GroupRegistrationData groupRemoveRequestData, Principal principal)
    {
        groupRemoveRequestData.setCreatorName(principal.getName());
        groupService.remove(groupRemoveRequestData);
        return new ResponseEntity(OK);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Page<GroupInformationData> getGroupsPaginated(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                         @RequestParam(value = "size", defaultValue = "10", required = false) int size)
    {
        return groupService.getPaginatedData(page, size);
    }

    @GetMapping(value = "/search/{name}")
    @ResponseStatus(value = HttpStatus.OK)
    public Set<GroupInformationData> searchGroups(@PathVariable("name") String name)
    {
        return groupService.searchGroupsByName(name);
    }
}