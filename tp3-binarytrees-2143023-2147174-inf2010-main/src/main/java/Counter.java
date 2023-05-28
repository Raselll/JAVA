public class Counter {
    //TODO
    private int nbAdd;
    private int nbSearch;

    public Counter(){
        this.nbAdd = 0;
        this.nbSearch = 0;
    }

    public int getAdd(){
        return nbAdd;
    }
    public int getSearch(){
        return nbSearch;
    }
    public void incrementAdd(){
        nbAdd++;
    }

    public void incrementSearch(){
        nbSearch++;
    }

}
