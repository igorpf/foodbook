package br.ufrgs.foodbook.controller;

import br.ufrgs.foodbook.dto.recipe.RecipeInformationData;
import br.ufrgs.foodbook.dto.recipe.RecipeRegistrationData;
import br.ufrgs.foodbook.service.RecipeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/secured/recipe")
public class RecipeController extends AbstractGenericController
{
    @Resource
    RecipeService recipeService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity createRecipe(@RequestBody RecipeRegistrationData recipeRegistrationData, Principal principal)
    {
        recipeRegistrationData.setCreatorName(principal.getName());
        recipeService.create(recipeRegistrationData);
        return new ResponseEntity(CREATED);
    }

    @GetMapping(value = "/{recipeId}")
    @ResponseStatus(value = HttpStatus.OK)
    public RecipeInformationData getRecipeInformation(@PathVariable("recipeId") String recipeId)
    {
        return recipeService.getRecipe(Long.valueOf(recipeId));
    }

    @GetMapping(value = "/group/{groupId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Page<RecipeInformationData> getGroupRecipes(@PathVariable("groupId") String groupId,
                                                       @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                       @RequestParam(value = "size", defaultValue = "10", required = false) int size)
    {
        return recipeService.getGroupRecipes(Long.valueOf(groupId), page, size);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Page<RecipeInformationData> getRecipesPaginated(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                           @RequestParam(value = "size", defaultValue = "10", required = false) int size)
    {
        return recipeService.getPaginatedData(page, size);
    }

    @PutMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity updateRecipe(@RequestBody RecipeRegistrationData recipeUpdateRequestData, Principal principal)
    {
        recipeUpdateRequestData.setCreatorName(principal.getName());
        recipeService.update(recipeUpdateRequestData);
        return new ResponseEntity(OK);
    }

    @DeleteMapping(value = "/remove")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity removeRecipe(RecipeRegistrationData recipeRemoveRequestData, Principal principal)
    {
        recipeRemoveRequestData.setCreatorName(principal.getName());
        recipeService.remove(recipeRemoveRequestData);
        return new ResponseEntity(OK);
    }

    @GetMapping(value = "/search/{name}")
    @ResponseStatus(value = HttpStatus.OK)
    public Page<RecipeInformationData> searchRecipe(@PathVariable("name") String name,
                                                    @RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                                    @RequestParam(value = "size", defaultValue = "10", required = false) int size)
    {
        return recipeService.searchRecipesByName(name, page, size);
    }
}
