class Solution {
    List<Integer> mainTeam = new ArrayList<>();
    public int[] smallestSufficientTeam(String[] requiredSkills, List<List<String>> candidates) {
        HashMap<String, Integer> skillsMap = new HashMap<>();
        int skillIndex = 0;
        for (String skill : requiredSkills) {
            skillsMap.put(skill, skillIndex++);
        }
        int requiredSkillsMask = (1 << skillIndex) - 1;
        int[] candidatesSkills = getCandidatesSkillsMask(candidates, skillsMap);
        List<Integer> localTeam = new ArrayList<>();
        findTeam(requiredSkillsMask, candidatesSkills, 0, 0, localTeam);
        return convertListToArray();
    }
    int[] getCandidatesSkillsMask(List<List<String>> candidates, HashMap<String, Integer> skillsMap) {
        int numOfCandidates = candidates.size();
        int[] candidatesSkills = new int[numOfCandidates];
        for (int i = 0; i < numOfCandidates; i++) {
            for (String skill : candidates.get(i)) {
                candidatesSkills[i] |= (1 << skillsMap.get(skill));
            }
        }
        return candidatesSkills;
    }
    void findTeam(int requiredSkillsMask, int[] candidatesSkills, int teamSkills, int personIndex, List<Integer> localTeam) {
        if (mainTeam.size() > 0 && localTeam.size() >= mainTeam.size() - 1 || personIndex == candidatesSkills.length) {
            return;
        }
        localTeam.add(personIndex);
        if ((teamSkills | candidatesSkills[personIndex]) == requiredSkillsMask) {
            mainTeam = new ArrayList<Integer>(localTeam);
            localTeam.remove(localTeam.size() - 1);
            return;
        } else if ((teamSkills | candidatesSkills[personIndex]) > teamSkills) {
            findTeam(requiredSkillsMask, candidatesSkills, teamSkills | candidatesSkills[personIndex], personIndex + 1, localTeam);
        }
        localTeam.remove(localTeam.size() - 1);
        findTeam(requiredSkillsMask, candidatesSkills, teamSkills, personIndex + 1, localTeam);
    }
    int[] convertListToArray() {
        int teamSize = mainTeam.size();
        int[] teamSkillsArray = new int[teamSize];
        for (int i = 0; i < teamSize; i++) {
            teamSkillsArray[i] = mainTeam.get(i);
        }
        return teamSkillsArray;
    }
}