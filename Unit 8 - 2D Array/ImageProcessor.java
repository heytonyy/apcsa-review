public class ImageProcessor {
    
    /**
     * Inverts the colors in the image (255 - original value).
     * @param image The original image as a 2D array of intensity values (0-255)
     * @return A new 2D array with inverted values
     */
    public static int[][] invert(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] result = new int[rows][cols];
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                result[r][c] = 255 - image[r][c];
            }
        }
        
        return result;
    }
    
    /**
     * Blurs the image by averaging each pixel with its neighbors.
     * @param image The original image as a 2D array of intensity values
     * @return A new 2D array with blurred values
     */
    public static int[][] blur(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] result = new int[rows][cols];
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int sum = 0;
                int count = 0;
                
                // Check all neighboring cells (including diagonals)
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        int newRow = r + dr;
                        int newCol = c + dc;
                        
                        // Only consider valid neighbors
                        if (newRow >= 0 && newRow < rows && 
                            newCol >= 0 && newCol < cols) {
                            sum += image[newRow][newCol];
                            count++;
                        }
                    }
                }
                
                // Calculate average
                result[r][c] = sum / count;
            }
        }
        
        return result;
    }
    
    /**
     * Finds the 3×3 region with the highest total brightness.
     * @param image The original image as a 2D array of intensity values
     * @return The sum of the brightest 3×3 region
     */
    public static int findBrightestRegion(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        
        // If image is smaller than 3×3, return sum of all elements
        if (rows < 3 || cols < 3) {
            int totalSum = 0;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    totalSum += image[r][c];
                }
            }
            return totalSum;
        }
        
        int maxSum = 0;
        
        // Check each possible 3×3 region
        for (int r = 0; r <= rows - 3; r++) {
            for (int c = 0; c <= cols - 3; c++) {
                int regionSum = 0;
                
                // Calculate sum of the 3×3 region
                for (int dr = 0; dr < 3; dr++) {
                    for (int dc = 0; dc < 3; dc++) {
                        regionSum += image[r + dr][c + dc];
                    }
                }
                
                // Update maxSum if this region has a higher sum
                if (regionSum > maxSum) {
                    maxSum = regionSum;
                }
            }
        }
        
        return maxSum;
    }
    
    // Test method
    public static void main(String[] args) {
        int[][] testImage = {
            {50, 60, 70, 80},
            {90, 100, 110, 120},
            {130, 140, 150, 160},
            {170, 180, 190, 200}
        };
        
        System.out.println("Original Image:");
        printImage(testImage);
        
        System.out.println("\nInverted Image:");
        int[][] invertedImage = invert(testImage);
        printImage(invertedImage);
        
        System.out.println("\nBlurred Image:");
        int[][] blurredImage = blur(testImage);
        printImage(blurredImage);
        
        System.out.println("\nBrightest 3×3 Region Sum: " + 
                          findBrightestRegion(testImage));
    }
    
    // Helper method to print the image
    private static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println();
        }
    }
}