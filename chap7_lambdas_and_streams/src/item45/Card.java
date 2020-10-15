package item45;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Card {
    public enum Suit { SPADE, HEART, DIAMOND, CLUB }
    public enum Rank { ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN,
                       EIGHT, NINE, TEN, JACK, QUEEN, KING }

    private final Suit suit;
    private final Rank rank;

    @Override public String toString() { return rank + " of " + suit + "S"; }

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    private static final List<Card> NEW_DECK = newDeck();

//    // Iterative Cartesian product computation
//    public static final List<Card> newDeck() {
//        List<Card> result = new ArrayList<>();
//        for (Suit suit : Suit.values())
//            for (Rank rank : Rank.values())
//                result.add(new Card(suit, rank));
//        return result;
//    }

    // flatMap
    // ・map(T -> R)は、Tのデータ型をRのデータ型に１：１の変換です。
    // ・flatMap(T -> Stream<R>)は、Tのデータ型からStream<R>に１：Nの変換です。
    //  ２次元配列が生成されるわけではなく、flatなStreamが返却されます。
    public static List<Card> newDeck() {
        return Stream.of(Suit.values())
                     // maps each element in a stream to a stream and then concatenates all of these new streams into a single stream (or flattens them)
                     .flatMap(suit ->
                            Stream.of(Rank.values()).map(rank -> new Card(suit, rank)))
                     .collect(toList());
    }

    public static void main(String[] args) {
        System.out.println(NEW_DECK);
    }
}
