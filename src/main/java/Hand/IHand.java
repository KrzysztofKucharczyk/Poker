package Hand;

import java.util.List;
import java.util.Map;

import CardModel.Suite;
import CardModel.ICard;
import HandCategory.HandCategory;
import HandCategory.HandCategoryMatcher.IHandCategoryMatcher;

public interface IHand {

	public List<ICard> getCardsList();

	public int getCardValue(int index);
	
	public List<Integer> getCardsValues();
	
	public Suite getCardSuite(int index);
	
	public int getHighestValue();
	
	public IHandCategoryMatcher getHandCategoryMatcher();
	
	public Map<Integer, Integer> getMap();
	
	public HandCategory getHandCategory();
}
