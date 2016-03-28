package DrawResolverTest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import CardModel.ICard;
import CardModel.PlayingCard;
import CardModel.Suite;
import DrawResolver.DrawResolver;
import Hand.IHand;
import Hand.PokerHand;
import Poker.GameResult;

public class DrawResolverTest {

	// -------------------------------
	@Test
	public void should_win_draw_between_high_cards() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(9, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(5, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(8, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(5, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		player.getHandCategory();

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.PLAYER_WON);
	}

	@Test
	public void should_lose_draw_between_high_cards() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(5, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(5, Suite.C));
		enemyCards.add(new PlayingCard(8, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.ENEMY_WON);
	}

	@Test
	public void should_stay_draw_between_high_cards() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(5, Suite.C));
		playerCards.add(new PlayingCard(8, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(5, Suite.C));
		enemyCards.add(new PlayingCard(8, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.DRAW);
	}

	// -------------------------------

	@Test
	public void should_win_draw_between_pair() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(5, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(8, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(9, Suite.C));
		enemyCards.add(new PlayingCard(14, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.PLAYER_WON);
	}

	@Test
	public void should_lose_draw_between_pair() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(8, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(2, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(7, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.ENEMY_WON);
	}

	@Test
	public void should_stay_draw_between_pair() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(8, Suite.C));
		playerCards.add(new PlayingCard(2, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(8, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.DRAW);
	}

	// -------------------------------

	@Test
	public void should_win_draw_between_two_pairs() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(6, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(6, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(14, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.PLAYER_WON);
	}

	@Test
	public void should_lose_draw_between_two_pairs() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(13, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(2, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(5, Suite.C));
		enemyCards.add(new PlayingCard(5, Suite.C));
		enemyCards.add(new PlayingCard(6, Suite.C));
		enemyCards.add(new PlayingCard(6, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.ENEMY_WON);
	}

	@Test
	public void should_stay_draw_between_two_pairs() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(5, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(5, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.DRAW);
	}

	// -------------------------------

	@Test
	public void should_win_draw_between_three_of_a_kind() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(5, Suite.C));
		playerCards.add(new PlayingCard(8, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(5, Suite.C));
		enemyCards.add(new PlayingCard(7, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.PLAYER_WON);
	}

	@Test
	public void should_lose_draw_between_three_of_a_kind() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.C));
		playerCards.add(new PlayingCard(2, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(8, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.ENEMY_WON);
	}

	@Test
	public void should_stay_draw_between_three_of_a_kind() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(7, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.C));
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(7, Suite.C));
		enemyCards.add(new PlayingCard(7, Suite.C));
		enemyCards.add(new PlayingCard(7, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.DRAW);
	}

	// -------------------------------
	@Test
	public void should_win_draw_between_straight() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(7, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(5, Suite.C));
		playerCards.add(new PlayingCard(6, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(6, Suite.C));
		enemyCards.add(new PlayingCard(5, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.PLAYER_WON);
	}

	@Test
	public void should_lose_draw_between_straight() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(5, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(6, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(7, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(5, Suite.C));
		enemyCards.add(new PlayingCard(6, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.ENEMY_WON);
	}

	@Test
	public void should_stay_draw_between_straight() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(6, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(5, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(6, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(5, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.DRAW);
	}

	// -------------------------------

	@Test
	public void should_win_draw_between_flush() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(5, Suite.C));
		playerCards.add(new PlayingCard(6, Suite.C));
		playerCards.add(new PlayingCard(8, Suite.C));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(5, Suite.C));
		enemyCards.add(new PlayingCard(7, Suite.C));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.PLAYER_WON);
	}

	@Test
	public void should_lose_draw_between_flush() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(5, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.C));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(5, Suite.C));
		enemyCards.add(new PlayingCard(6, Suite.C));
		enemyCards.add(new PlayingCard(8, Suite.C));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.ENEMY_WON);
	}

	@Test
	public void should_stay_draw_between_flush() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(5, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.C));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(5, Suite.C));
		enemyCards.add(new PlayingCard(7, Suite.C));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.DRAW);
	}

	// -------------------------------

	@Test
	public void should_win_draw_between_four_of_a_kind() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(8, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(9, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.PLAYER_WON);
	}

	@Test
	public void should_lose_draw_between_four_of_a_kind() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(7, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.C));
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(8, Suite.C));
		enemyCards.add(new PlayingCard(8, Suite.C));
		enemyCards.add(new PlayingCard(8, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(8, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.ENEMY_WON);
	}

	@Test
	public void should_stay_draw_between_four_of_a_kind() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(7, Suite.C));
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(7, Suite.C));
		enemyCards.add(new PlayingCard(7, Suite.C));
		enemyCards.add(new PlayingCard(7, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(7, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.DRAW);
	}

	// -------------------------------

	@Test
	public void should_win_draw_between_full() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(8, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(8, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(8, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(7, Suite.C));
		enemyCards.add(new PlayingCard(7, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.PLAYER_WON);
	}

	@Test
	public void should_lose_draw_between_full() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(8, Suite.C));
		enemyCards.add(new PlayingCard(8, Suite.C));
		enemyCards.add(new PlayingCard(8, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.ENEMY_WON);
	}

	@Test
	public void should_stay_draw_between_full() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.D));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(7, Suite.C));
		enemyCards.add(new PlayingCard(7, Suite.C));
		enemyCards.add(new PlayingCard(7, Suite.D));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.DRAW);
	}

	// -------------------------------

	@Test
	public void should_win_draw_between_straight_flush() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(5, Suite.C));
		playerCards.add(new PlayingCard(6, Suite.C));
		playerCards.add(new PlayingCard(7, Suite.C));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(5, Suite.C));
		enemyCards.add(new PlayingCard(6, Suite.C));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.PLAYER_WON);
	}

	@Test
	public void should_lose_draw_between_straight_flush() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(5, Suite.C));
		playerCards.add(new PlayingCard(6, Suite.C));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(5, Suite.C));
		enemyCards.add(new PlayingCard(6, Suite.C));
		enemyCards.add(new PlayingCard(7, Suite.C));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.ENEMY_WON);
	}

	@Test
	public void should_stay_draw_between_straight_flush() {
		List<ICard> playerCards = new ArrayList<>();
		playerCards.add(new PlayingCard(2, Suite.C));
		playerCards.add(new PlayingCard(3, Suite.C));
		playerCards.add(new PlayingCard(4, Suite.C));
		playerCards.add(new PlayingCard(5, Suite.C));
		playerCards.add(new PlayingCard(6, Suite.C));

		List<ICard> enemyCards = new ArrayList<>();
		enemyCards.add(new PlayingCard(2, Suite.C));
		enemyCards.add(new PlayingCard(3, Suite.C));
		enemyCards.add(new PlayingCard(4, Suite.C));
		enemyCards.add(new PlayingCard(5, Suite.C));
		enemyCards.add(new PlayingCard(6, Suite.C));

		IHand player = new PokerHand(playerCards);
		IHand enemy = new PokerHand(enemyCards);

		GameResult result = DrawResolver.resolve(player, enemy);

		assertTrue(result == GameResult.DRAW);
	}
}
