package com.marcastr0

case class Card(value: String, suit: String) {
  override def toString: String = value + suit
}

object FaroShuffle {

  def newDeck(): Array[Card] = {
    val suits = List("H", "C", "D", "S")
    val firstHalf = for {
      suit <- suits.slice(0, suits.length / 2)
      i <- 1 to 13
    } yield i match {
      case 1 => Card("A", suit)
      case 11 => Card("J", suit)
      case 12 => Card("Q", suit)
      case 13 => Card("K", suit)
      case _ => Card(i.toString, suit)
    }
    val secondHalf = for {
      suit <- suits.slice(suits.length / 2, suits.length)
      i <- 13 to 1 by -1
    } yield i match {
      case 1 => Card("A", suit)
      case 11 => Card("J", suit)
      case 12 => Card("Q", suit)
      case 13 => Card("K", suit)
      case _ => Card(i.toString, suit)
    }
    (firstHalf ++ secondHalf).toArray
  }

  def inFaro(deck: Array[Card]): Array[Card] = {
    deck.slice(deck.length / 2, deck.length) zip deck.slice(0, deck.length / 2) flatMap (x => List(x._1, x._2))
  }

  def outFaro(deck: Array[Card]): Array[Card] = {
    deck.slice(0, deck.length / 2) zip deck.slice(deck.length / 2, deck.length) flatMap (x => List(x._1, x._2))
  }
}
