package K;

class readLines {
    private String inPut;
    public readLines(String inPut){
        this.inPut = inPut;
    }

    public static int[] readLine(String inPut){
        String[] tokens = inPut.split(" ",-1);
        int[] result = new int[tokens.length];
        for (int i = 0;i< tokens.length;i++){
            result[i] = Integer.parseInt(tokens[i]) ;
        }
        return result;
    }
}
