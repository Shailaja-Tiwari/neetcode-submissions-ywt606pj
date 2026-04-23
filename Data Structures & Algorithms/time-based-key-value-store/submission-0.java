class TimeMap {
    HashMap<String, List<String>> valuesMap;
    HashMap<String, List<Integer>> timesMap;

    public TimeMap() {
        valuesMap = new HashMap<>();
        timesMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        valuesMap.putIfAbsent(key, new ArrayList<String>());
        timesMap.putIfAbsent(key, new ArrayList<Integer>());

        valuesMap.get(key).add(value);
        timesMap.get(key).add(timestamp);
    }

    public String get(String key, int timestamp) {
        if (!timesMap.containsKey(key)) return "";

        List<Integer> times = timesMap.get(key);
        List<String> values = valuesMap.get(key);

        int l = 0;
        int r = times.size() - 1;
        String result = "";

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (times.get(mid) <= timestamp) {
                result = values.get(mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}