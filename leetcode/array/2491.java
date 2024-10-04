class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int totalSkill = 0;
        Map<Integer, Integer> skillMap = new HashMap<>();
        for (int s: skill) {
            totalSkill += s;
            skillMap.put(s, skillMap.getOrDefault(s, 0) + 1);
        }

        int teamSkill = totalSkill / (n / 2);
        long chemistry = 0;
        for (int s: skill) {
            if (!skillMap.containsKey(s)) {
                continue;
            }
            skillMap.put(s, skillMap.get(s) - 1);
            if (skillMap.get(s) == 0) {
                skillMap.remove(s);
            }

            int needed = teamSkill - s;
            if (!skillMap.containsKey(needed)) {
                return -1;
            }
            skillMap.put(needed, skillMap.get(needed) - 1);
            if (skillMap.get(needed) == 0) {
                skillMap.remove(needed);
            }
            chemistry += (long) s * needed;
        }
        return chemistry;
    }
}