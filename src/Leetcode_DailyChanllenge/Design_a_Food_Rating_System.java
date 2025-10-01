package Leetcode_DailyChanllenge;

import java.util.*;

public class Design_a_Food_Rating_System {
    class FoodRatings {
        Map<String, String> foodCuisine = new HashMap<>();
        Map<String, Integer> foodRating = new HashMap<>();
        Map<String, PriorityQueue<String>> cuisineHeap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                foodCuisine.put(foods[i], cuisines[i]);
                foodRating.put(foods[i], ratings[i]);

                cuisineHeap.putIfAbsent(cuisines[i], new PriorityQueue<>(
                        (a, b) -> {
                            int r1 = foodRating.get(a), r2 = foodRating.get(b);
                            if (r1 != r2) return r2 - r1; // higher rating first
                            return a.compareTo(b);        // lexicographically smaller
                        }
                ));

                cuisineHeap.get(cuisines[i]).add(foods[i]);
            }
        }

        public void changeRating(String food, int newRating) {
            foodRating.put(food, newRating);
            cuisineHeap.get(foodCuisine.get(food)).remove(); // push new value
        }

        public String highestRated(String cuisine) {
            PriorityQueue<String> pq = cuisineHeap.get(cuisine);
            while (true) {
                String top = pq.peek();
                // if the top matches the latest rating → valid
                if (foodRating.get(top) == foodRating.get(top)) {
                    return top;
                }
                pq.poll(); // remove outdated
            }
        }
    }

}
