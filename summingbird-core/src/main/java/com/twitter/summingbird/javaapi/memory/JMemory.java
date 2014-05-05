package com.twitter.summingbird.javaapi.memory;

import scala.Function1;
import scala.Option;
import scala.collection.TraversableOnce;
import scala.collection.mutable.Map;

import com.twitter.summingbird.javaapi.JProducer;
import com.twitter.summingbird.javaapi.JProducers;
import com.twitter.summingbird.javaapi.Service;
import com.twitter.summingbird.javaapi.Sink;
import com.twitter.summingbird.javaapi.Source;
import com.twitter.summingbird.javaapi.Store;
import com.twitter.summingbird.memory.Memory;

public class JMemory {

  static <T> JProducer<Memory, T> source(TraversableOnce<T> source) {
    return JProducers.source(new Source<Memory, TraversableOnce<T>, T>(source));
  }

  static <K,V> Store<Memory, Map<K, V>, K, V> store(Map<K, V> store) {
    return new Store<Memory, Map<K, V>, K, V>(store);
  }

  static <T> Sink<Memory, Function1<T, Void>, T> sink(Function1<T, Void> sink) {
    return new Sink<Memory, Function1<T, Void>, T>(sink);
  }

  static <K,V> Service<Memory, Function1<K, Option<V>>, K, V> service(Function1<K, Option<V>> service) {
    return new Service<Memory, Function1<K, Option<V>>, K, V>(service);
  }

}
