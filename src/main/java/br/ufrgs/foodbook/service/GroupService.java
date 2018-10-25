package br.ufrgs.foodbook.service;

import br.ufrgs.foodbook.dto.group.GroupInformationData;
import br.ufrgs.foodbook.dto.group.GroupRegistrationData;
import br.ufrgs.foodbook.model.groups.Group;

public interface GroupService extends GenericService<GroupRegistrationData, Group>
{
    GroupInformationData getGroup(String groupName);
}
