class RecentCounter {
    private List<Integer> calls;

    public RecentCounter() {
        calls = new ArrayList<>();
    }

    public int ping(int t) {
        int lowTime = t - 3000;
        int recentCalls = findRecentCalls(lowTime);
        calls.add(t);
        return recentCalls + 1;
    }

    private int findRecentCalls(int lowTime) {
        int beg = 0, end = calls.size() - 1;
        if (beg > end)
            return 0;
        if (beg == end)
            return calls.get(beg) >= lowTime ? 1 : 0;

        if (calls.get(beg) >= lowTime)
            return end - beg + 1;

        if (calls.get(end) < lowTime)
            return 0;

        while (end - beg > 1) {
            int mid = beg + (end - beg) / 2;
            if (calls.get(mid) >= lowTime)
                end = mid;
            else
                beg = mid;
        }

        return calls.size() - end;
    }
}
