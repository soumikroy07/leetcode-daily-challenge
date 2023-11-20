class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int lastHouse[] = new int[3]; // M , P , G
        int n = garbage.length;
        int metal[] = new int[n];
        int paper[] = new int[n];
        int glass[] = new int[n];

        for(int i=0; i<n; i++){
            String gar = garbage[i];
            int mUnit = 0, pUnit = 0, gUnit = 0;
            for(char c: gar.toCharArray()){
                
                if(c == 'M'){
                    lastHouse[0] = i;
                    mUnit++;
                }else if(c == 'P'){
                    lastHouse[1] = i;
                    pUnit++;
                }else{
                    lastHouse[2] = i;
                    gUnit++;
                }
            }
            metal[i] = mUnit;
            paper[i] = pUnit;
            glass[i] = gUnit;
        }

        int travelTime = 0;
        for(int house: lastHouse){
            for(int i=0; i<house; i++){
                travelTime += travel[i];
            }
        }

        int collectTime = 0;
        for(int m : metal){
            collectTime += m;
        }

        for(int p : paper){
            collectTime += p;
        }

        for(int g : glass){
            collectTime += g;
        }

        return collectTime + travelTime;
    }
}