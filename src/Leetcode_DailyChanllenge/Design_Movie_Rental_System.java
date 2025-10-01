package Leetcode_DailyChanllenge;

import java.util.*;

public class Design_Movie_Rental_System {
    class MovieRentingSystem {

        Map<String,Integer> priceMap=new HashMap<>();
        Map<Integer,Set<Movie> > unRentedMap=new HashMap<>();
        Comparator<Movie> comp;
        TreeSet<Movie> rented;
        int n;


        public MovieRentingSystem(int n, int[][] entries) {

            this.comp=(a,b)->{
                if (a.price!=b.price) return Integer.compare(a.price,b.price);
                if (a.shop!= b.shop) return Integer.compare(a.shop,b.shop);
                return Integer.compare(a.movie,b.movie);
            };
            this.n=n;

            this.rented=new TreeSet<>(comp);
            for (int[] entry:entries){
                int shop=entry[0];
                int movie=entry[1];
                int price=entry[2];



                priceMap.put(fun(shop,movie),price);

         Set<Movie> set=  unRentedMap.getOrDefault(movie,new TreeSet<Movie>(comp));
         set.add(new Movie(price,movie,shop));
         unRentedMap.put(movie,set);

            }
        }

        public List<Integer> search(int movie) {
           Set<Movie> set=unRentedMap.get(movie);
           int cnt=0;
           List<Integer>list=new ArrayList<>();
             if (set.size()==0) return list;
           for (Movie m:set){
               if (cnt==Math.min(set.size(),5)) break;
               list.add(m.shop);
               cnt--;
           }
           return list;
        }

        public void rent(int shop, int movie) {
            int price=priceMap.get(fun(shop,movie));
            Movie m=new Movie(shop,movie,price);
             unRentedMap.get(movie).remove(m);
             rented.add(m);
        }

        public void drop(int shop, int movie) {
            int price=priceMap.get(fun(shop,movie));
            Movie m=new Movie(shop,movie,price);
            rented.remove(m);

            Set<Movie> s=unRentedMap.get(movie);
            unRentedMap.put(movie,s);

        }

        public List<List<Integer>> report() {
           List<List<Integer>> result=new ArrayList<>();
           int cnt=0;
           if (rented.size()==0) return result;
           for (Movie m:rented){
               if (cnt==Math.min(rented.size(), 5)){
                   break;
               }

               List<Integer> list=new ArrayList<>();
               list.add(m.shop,m.movie);
               cnt++;
           }
           return result;
        }

        String fun(int a,int b){
            return a+"_"+b;
        }


        static class Movie{
            int price;
            int movie;
            int shop;

            public Movie(int price, int movie, int shop) {
                this.price = price;
                this.movie = movie;
                this.shop = shop;
            }

            @Override
            public boolean equals(Object o) {
                if (!(o instanceof Movie)) return false;
                Movie other=(Movie) o;
                return price==other.price&&movie==other.movie&&shop==other.shop;
            }

            @Override
            public int hashCode() {
                return Objects.hash(price,movie,shop);
            }
        }
    }
}
