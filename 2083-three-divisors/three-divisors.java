class Solution {

    public Set<Integer> es = es();
    public boolean isThree(int n) {
        return es.contains(n);
    }

    public Set<Integer> es(){

        Set<Integer> s = new HashSet<>();
        s.add(4);s.add(169);s.add(961);s.add(2809);s.add(5329);
        s.add(9);s.add(289);s.add(1369);s.add(3481);s.add(6241);
        s.add(25);s.add(361);s.add(1681);s.add(3721);s.add(6889);
        s.add(49);s.add(529);s.add(1849);s.add(4489);s.add(7921);
        s.add(121);s.add(841);s.add(2209);s.add(5041);s.add(9409);
        return s;
    }

}