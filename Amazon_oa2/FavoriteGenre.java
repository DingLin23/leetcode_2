import java.util.*;
//time:o(n^2);
//space: o(n^2)
public class FavoriteGenres {
    public static void main(String[] args) {
        Map<String, List<String>> userMap = new HashMap<>();
        List<String> list1 = Arrays.asList("song1", "song2", "song3", "song4", "song8");
        List<String> list2 = Arrays.asList("song5", "song6", "song7");
        userMap.put("David", list1);
        userMap.put("Emma", list2);
        Map<String, List<String>> genreMap = new HashMap<>();
        List<String> list3 = Arrays.asList("song1", "song3");
        List<String> list4 = Arrays.asList("song7");
        List<String> list5 = Arrays.asList("song2", "song4");
        List<String> list6 = Arrays.asList("song5", "song6");
        List<String> list7 = Arrays.asList("song8", "song9");
        genreMap.put("Rock", list3);
        genreMap.put("Dubstep", list4);
        genreMap.put("Techno", list5);
        genreMap.put("Pop", list6);
        genreMap.put("Jazz", list7);
        System.out.println(favoriteGenre(userMap, genreMap));
    }

    private static Map<String, List<String>> favoriteGenre(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres) {
//        Map<String, List<String>> output = new HashMap<>();
//
//        //case that if songGenres is empty
//        if (songGenres.size() == 0) {
//            for (Map.Entry<String, List<String>> entry : userSongs.entrySet()) {
//                output.put(entry.getKey(), new ArrayList<>());
//            }
//            return output;
//        }
        Map<String, List<String>> res = new HashMap<>();
        //case that if songGenre is empty
        if (songGenres.size() == 0) {
            for (Map.Entry<String, List<String>> entry : songGenres.entrySet()) {
                res.put(entry.getKey(), new ArrayList<>());
            }
            return res;
        }

        //create new HashMap with song to genre mapping
        Map<String, String> songPairGenre = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : songGenres.entrySet()) {
            for (String song : entry.getValue()) {
                songPairGenre.put(song, entry.getKey());
            }
        }

        // count how many songs appear in the same genre
        Map<String, Integer> genre = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : userSongs.entrySet()) {
            genre.clear();//done by one user go to next one;
            for (String song : entry.getValue()) {
                genre.put(songPairGenre.get(song), genre.getOrDefault(songGenres.get(song), 0) + 1);
            }
            int max = 0;
            List<String> list = new ArrayList<>();
            for (Map.Entry<String, Integer> new_entry : genre.entrySet()) {
                if (new_entry.getValue() > max) {
                    max = new_entry.getValue();
                    list.clear();
                    list.add(new_entry.getKey());
                }
                //if has same frequency still need to add to list;
                else if (new_entry.getValue() == max) {
                    list.add(new_entry.getKey());
                }
            }
            res.put(entry.getKey(),list);
        }
        return res;
    }
}
