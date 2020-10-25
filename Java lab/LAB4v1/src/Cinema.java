public class Cinema {
    private int size = 1;
    private Movie[] array = new Movie[size];
    private int current = 0;


    //Adds new items to the array.
    public boolean add(String название, int год_производства, String жанр,
                       String режиссер, int время_показа, int бюджет){
        //Returns 'false' and quits the method without adding new element to the array,
        // if there is at least one variable, which meets its condition.
        if(название == null || год_производства <= 0 || жанр == null
                || режиссер == null || время_показа <= 0 || бюджет <= 0){ return false; }

        //Increases the array if there is no room for the new array.
        if(!this.isEmpty()) {
            this.extendArray(1);
            ++this.current;
        }

        array[current] = new Movie(название, год_производства, жанр,
                режиссер, время_показа, бюджет);

        return true;
    }


    //Deletes the last array from the array.
    public boolean delete(){
        return this.narrowArray(1);
    }


    //Displays all the array's elements information.
    public void printAll(){
        int count = 0;

        for(Movie temp : this.array){
            //Returns 'true' if array's cell contains 'null' value.
            if(temp == null) {
                System.out.println("No data has been found!");
                return;
            }

            System.out.println("Фильм #" + ++count +
                    ". \n=============================================================\n" +
                    "Название: " + temp.getTitle() +
                    "\nЖанр: " + temp.getGenre() +
                    "\nГод выпуска: " + temp.getGenre() +
                    "\nВремя показа: " + temp.getDuration() + "минут" +
                    "\nРежиссер: " + temp.getDirector() +
                    "\nБюджет: " + temp.getBudget() + " долл США" +
                    "\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

            //Prints new line when the array's last element will be used.
            if(count == this.array.length - 1){ System.out.println(); }
        }
    }


    //Returns 'true' value if the current index points on the empty array's cell.
    private boolean isEmpty(){
        return this.array[current] == null;
    }


    //Increases the field array by the input size. Returns 'true' value if the increasing was permitted.
    //Other wise - 'false'.
    private boolean extendArray(int size){
        //Return 'false' value if the input size is less than or equal to zero value.
        if(size <= 0){ return false; }

        Movie[] temp = new Movie[this.array.length + size];
        System.arraycopy(this.array, 0, temp, 0, this.array.length);
        array = temp;

        return true;
    }


    //Decreases the field array by the input size. Returns 'true' value if the decreasing was permitted.
    //Other wise - 'false'.
    private boolean narrowArray(int size){
        //Return 'false' value if the input size is greater than or equal to the zero value
        // or the current index points on the array's last element, which has 'null' value.
        if(size <= 0 || this.array[this.current] == null) { return false; }

        //Sets the first array's cell to 'null' value and decreases the current index by one
        // if there is only one cell in the array. Otherwise, the if-statement will be skipped.
        if(this.array.length == 1) {
            this.array[current] = null;
            return true;
        }

        Movie[] temp = new Movie[this.array.length - size];
        System.arraycopy(this.array, 0, temp, 0, temp.length);
        --this.current;

        array = temp;
        return true;
    }


    //Inner class, created to hold all the information about the bought array.
    private class Movie {
        private String название;
        private int год_производства;
        private String жанр;
        private String режиссер;
        private int время_показа;
        private int бюджет;

        public Movie(String название, int год_производства, String жанр,
                     String режиссер, int время_показа, int бюджет) {
            this.название = название;
            this.год_производства = год_производства;
            this.жанр = жанр;
            this.режиссер = режиссер;
            this.время_показа = время_показа;
            this.бюджет = бюджет;
        }

        public String getTitle() {
            return название;
        }

        public int getProductionYear() {
            return год_производства;
        }

        public String getGenre() {
            return жанр;
        }

        public String getDirector() {
            return режиссер;
        }

        public int getDuration() {
            return время_показа;
        }

        public int getBudget() {
            return бюджет;
        }
    }
}