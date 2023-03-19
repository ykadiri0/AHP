package com.pfa2023.AHP.Fuzzy;

public class MatrixAggregation {

    public static double[][][] weightedAggregation(double[][][][] cube, double[] weights) {
        int numMatrices = cube.length;
        int numRows = cube[0].length;
        int numCols = cube[0][0].length;
        double[][][] aggregatedMatrix = new double[numRows][numCols][3];
        System.out.println(numCols);
        System.out.println(numRows);

        for (int i = 0; i < numRows; i++) {

            for (int j = 0; j < numCols; j++) {
                for (int k = 0; k < 3; k++) {
                    double[] values = cube[k][i][j];
                    double first = values[0];
                    double second = values[1];
                    double third = values[2];
                    // Calculate the weighted average of the second element
                    double sum = 0;
                    double weightSum = 0;
                    for (int l = 0; l < weights.length; l++) {
                        sum += values[1] * weights[l];
                        weightSum += weights[l];
                    }
                    double avg = sum / weightSum;

                    // Set the aggregated value for the current cell
                    if (k == 0) {
                        aggregatedMatrix[i][j][k] = Math.max(first, aggregatedMatrix[i][j][k]);
                    } else if (k == 1) {
                        aggregatedMatrix[i][j][k] = avg;
                    } else {
                        aggregatedMatrix[i][j][k] = Math.max(third, aggregatedMatrix[i][j][k]);
                    }
                }
            }
        }
        return aggregatedMatrix;
    }

    public static void main(String[] args) {
        // Example usage:

        // Three 2x2 matrices to aggregate
        double[][][] matrix1 = { { {1, 2, 3}, {4, 5, 6} , {4, 5, 9}},
                { {7, 8, 9}, {10, 11, 12}, {4, 5, 6} } };
        double[][][] matrix2 = { { {13, 14, 15}, {16, 17, 18}, {4, 5, 6} }
                , { {19, 20, 21}, {22, 23, 24}, {4, 5, 6} } };
        double[][][] matrix3 = { { {25, 26, 27}, {28, 29, 30}, {4, 5, 6} },
                { {31, 32, 33}, {34, 35, 36}, {4, 5, 6} } };
        double[][][] matrix4 = { { {25, 26, 27}, {28, 29, 30}, {4, 5, 6} },
                { {31, 32, 33}, {34, 35, 36}, {4, 5, 6} } };

        // Create a 3D cube to hold the matrices
        double[][][][] cube = { matrix1, matrix2};

        // Three weights corresponding to each dimension of the cube
        double[] weights = {0.2, 0.3, 0.5};

        // Create the aggregated matrix using the weighted aggregation function
        double[][][] aggregatedMatrix = weightedAggregation(cube, weights);

        // Output the aggregated matrix
        for (int i = 0; i < aggregatedMatrix.length; i++) {
            for (int j = 0; j < aggregatedMatrix[0].length; j++) {
                for (int k = 0; k < aggregatedMatrix[0][0].length; k++) {
                    System.out.print(aggregatedMatrix[i][j][k] + " ");
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}
