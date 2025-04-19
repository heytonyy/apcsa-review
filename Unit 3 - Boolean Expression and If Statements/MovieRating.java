public class MovieRating {
    private String title;
    private double viewerRating;
    private double criticRating;
    
    /**
     * Constructs a MovieRating object with the given title and ratings.
     * @param title the movie title
     * @param viewerRating the average viewer rating (0.0 to 5.0)
     * @param criticRating the average critic rating (0.0 to 5.0)
     */
    public MovieRating(String title, double viewerRating, double criticRating) {
        this.title = title;
        
        // Ensure ratings are within valid range
        if (viewerRating < 0.0 || viewerRating > 5.0) {
            throw new IllegalArgumentException("Viewer rating must be between 0.0 and 5.0");
        }
        if (criticRating < 0.0 || criticRating > 5.0) {
            throw new IllegalArgumentException("Critic rating must be between 0.0 and 5.0");
        }
        
        this.viewerRating = viewerRating;
        this.criticRating = criticRating;
    }
    
    /**
     * Returns the movie title.
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Returns the viewer rating.
     * @return the viewer rating
     */
    public double getViewerRating() {
        return viewerRating;
    }
    
    /**
     * Returns the critic rating.
     * @return the critic rating
     */
    public double getCriticRating() {
        return criticRating;
    }
    
    /**
     * Determines if the movie is highly recommended.
     * A movie is highly recommended if both viewer and critic ratings are 4.0 or higher.
     * @return true if the movie is highly recommended, false otherwise
     */
    public boolean isHighlyRecommended() {
        return viewerRating >= 4.0 && criticRating >= 4.0;
    }
    
    /**
     * Determines if the movie has mixed reviews.
     * A movie has mixed reviews if the absolute difference between
     * viewer and critic ratings is greater than 2.0.
     * @return true if the movie has mixed reviews, false otherwise
     */
    public boolean hasMixedReviews() {
        double difference = Math.abs(viewerRating - criticRating);
        return difference > 2.0;
    }
    
    /**
     * Determines if the movie is recommended based on various criteria.
     * A movie is recommended if:
     * 1. It is highly recommended, OR
     * 2. The viewer rating is 4.5 or higher (regardless of critic rating), OR
     * 3. The average of viewer and critic ratings is 3.5 or higher AND it doesn't have mixed reviews
     * 
     * @return true if the movie is recommended, false otherwise
     */
    public boolean isRecommended() {
        // Check if highly recommended
        if (isHighlyRecommended()) {
            return true;
        }
        
        // Check if viewer rating is very high
        if (viewerRating >= 4.5) {
            return true;
        }
        
        // Check if average rating is good and no mixed reviews
        double averageRating = (viewerRating + criticRating) / 2.0;
        if (averageRating >= 3.5 && !hasMixedReviews()) {
            return true;
        }
        
        // If none of the conditions are met, it's not recommended
        return false;
    }
    
    /**
     * Returns a string representation of the movie's recommendation status.
     * @return a string representing the movie's status
     */
    public String getRecommendationStatus() {
        if (isHighlyRecommended()) {
            return title + " - Highly Recommended";
        } else if (hasMixedReviews()) {
            return title + " - Mixed Reviews";
        } else if (isRecommended()) {
            return title + " - Recommended";
        } else {
            return title + " - Not Recommended";
        }
    }
}