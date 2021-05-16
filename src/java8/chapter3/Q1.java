package java8.chapter3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;

public class Q1 {

  public static void main(String[] args) {
    List<Artist> allArtists = new ArrayList<>();
    allArtists.add(new Artist("London"));
    allArtists.add(new Artist("London"));
    allArtists.add(new Artist("London"));
    allArtists.add(new Artist("New York"));
    allArtists.add(new Artist("Chicago"));
    allArtists.add(new Artist("Los Angels"));
    long count = allArtists.stream().filter(artist -> artist.isFrom.equals("London")).count();
    List<Artist> londonArtists =
        allArtists.stream()
            .filter(artist -> artist.isFrom.equals("London"))
            .collect(Collectors.toList());
    System.out.println(count);
    System.out.println(londonArtists);

    List<String> collected = Stream.of("a", "b", "c").collect(Collectors.toList());
    System.out.println(collected.equals(Arrays.asList("a", "b", "c")));

    List<String> collectedMap =
        Stream.of("a", "b", "c", "c", "d", "b", "b", "a", "o", "i")
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    System.out.println(collectedMap);

    List<String> beginningWithNumbers =
        Stream.of("a", "1abc", "abc1")
            .filter(value -> isDigit(value.charAt(0)))
            .collect(Collectors.toList());
    System.out.println(beginningWithNumbers);

    List<Integer> together =
        Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

    System.out.println(together);

    List<Track> tracks =
        Arrays.asList(
            new Track("Bakai", 526),
            new Track("Violets for your furst", 378),
            new Track("Time was", 451));
    Track shortestTrack = tracks.stream().min(Comparator.comparing(track -> track.point)).get();
    System.out.println(shortestTrack);

    int sum = Stream.of(1, 2, 3).reduce(0, Integer::sum);
    System.out.println(sum);
  }

  static class Artist {
    String isFrom;

    public Artist(String isFrom) {
      this.isFrom = isFrom;
    }

    @Override
    public String toString() {
      return "Artist{" + "isFrom='" + isFrom + '\'' + '}';
    }
  }

  static class Track {
    String name;
    int point;

    public Track(String name, int point) {
      this.name = name;
      this.point = point;
    }

    @Override
    public String toString() {
      return "Track{" + "name='" + name + '\'' + ", point=" + point + '}';
    }
  }
}
