//Задание: Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.
//Сгенерируем квадратную матрицу, и последовательно повернем ее на 90, 180(90+90), 270(90+90+90) градусов.
public class Matrix {
    public static void main(String[] args) {
        int size = 3; //задаем размер квадратной матрицы
        int[][] array = new int[size][size];
        array = generate(array, size);
        System.out.println("рандомная матрица: "); //выводим в консоль исходную матрицу
        OutMatrix(array, size);
        rotate90(array, size);
        System.out.println("поворот матрицы на 90 градусов: "); //выводим в консоль матрицу с поворотом 90 град.
        OutMatrix(array, size);
        rotate90(array, size);
        System.out.println("поворот матрицы на 180 градусов: "); //выводим в консоль матрицу с поворотом 180 град.
        OutMatrix(array, size);
        rotate90(array, size);
        System.out.println("поворот матрицы на 270 градусов: "); //выводим в консоль матрицу с поворотом 270 град.
        OutMatrix(array, size);

    }
    //функция заполнения матицы случайными значениями от 0 до 5
    public static int[][] generate(int[][] array, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                array[i][j] = (int) (Math.random() * 5);
            }
        }
        return array;
    }
    //функция вывода матрицы в консоль
    public static void OutMatrix(int[][] array, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
    //функция поворота матрицы на 90 гр.
    public static int[][] rotate90(int[][] array, int size) {
        for (int i = 0; i < size / 2; i++) {
            for (int j = i; j < size - 1 - i; j++) {
                int x = array[i][j];
                array[i][j] = array[j][size - 1 - i];
                array[j][size - 1 - i] = array[size - 1 - i][size - 1 - j];
                array[size - 1 - i][size - 1 - j] = array[size - 1 - j][i];
                array[size - 1 - j][i] = x;
            }
        }
        return array;
    }
}
