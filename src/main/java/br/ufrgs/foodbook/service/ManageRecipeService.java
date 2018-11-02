package br.ufrgs.foodbook.service;

import br.ufrgs.foodbook.dto.recipe.RecipeFeedbackInformationData;
import br.ufrgs.foodbook.dto.recipe.RecipeFeedbackRegistrationData;

public interface ManageRecipeService
{
    void registerFeedback(RecipeFeedbackRegistrationData recipeFeedbackRegistrationData);

    RecipeFeedbackInformationData getRecipeFeedbackAverageValues(Long recipeId);

    void addRecipeToFavorite(Long recipeId, String username);

    void removeRecipeFromFavorite(Long valueOf, String name);

    void updateFeedback(RecipeFeedbackRegistrationData recipeFeedbackRegistrationData);
}
