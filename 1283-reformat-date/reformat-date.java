class Solution {
    public String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();
        Map<String,String> map= new HashMap<>();
        map.put("Jan","01");map.put("Feb","02");map.put("Mar","03");map.put("Apr","04");map.put("May","05");map.put("Jun","06");
        map.put("Jul","07");map.put("Aug","08");map.put("Sep","09");map.put("Oct","10");map.put("Nov","11");map.put("Dec","12");
        String[] d = date.split(" ");
        sb.append(d[2]+"-");
        sb.append(map.get(d[1])+"-");
        String day = d[0].substring(0,d[0].length()-2);
        if(day.length()==1)
        sb.append("0");
        sb.append(day);
        return sb.toString();
    }
}