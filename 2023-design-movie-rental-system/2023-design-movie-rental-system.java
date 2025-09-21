class MovieRentingSystem {
    private Map<Integer, TreeSet<int[]>> movieToAvailable; // movie -> available shops
    private TreeSet<int[]> rented; // all rented movies
    private Map<String, Integer> priceMap; // (shop,movie) -> price

    public MovieRentingSystem(int n, int[][] entries) {
        movieToAvailable = new HashMap<>();
        rented = new TreeSet<>((a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0]; // price
            if (a[1] != b[1])
                return a[1] - b[1]; // shop
            return a[2] - b[2]; // movie
        });
        priceMap = new HashMap<>();

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(shop + "#" + movie, price);

            movieToAvailable
                    .computeIfAbsent(movie, k -> new TreeSet<>((a, b) -> {
                        if (a[0] != b[0])
                            return a[0] - b[0]; // price
                        return a[1] - b[1]; // shop
                    }))
                    .add(new int[] { price, shop });
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!movieToAvailable.containsKey(movie))
            return res;

        int count = 0;
        for (int[] entry : movieToAvailable.get(movie)) {
            res.add(entry[1]); // shop
            if (++count == 5)
                break;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        movieToAvailable.get(movie).remove(new int[] { price, shop });
        rented.add(new int[] { price, shop, movie });
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        rented.remove(new int[] { price, shop, movie });
        movieToAvailable.get(movie).add(new int[] { price, shop });
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (int[] entry : rented) {
            res.add(Arrays.asList(entry[1], entry[2])); // [shop, movie]
            if (++count == 5)
                break;
        }
        return res;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */