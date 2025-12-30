class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long type1Cost = (long)Math.max(need1, need2) * (long)costBoth;

        long type2Cost = (long)cost1 * (long)need1 + (long)cost2 * (long)need2;

        long type3Cost = (long)Math.min(need1, need2) * (long)costBoth + (long)(need1 - Math.min(need1, need2)) * (long)cost1
                            + (long)(need2 - Math.min(need1, need2)) * (long)cost2;

        return Math.min(Math.min(type1Cost, type2Cost), type3Cost);
    }
}