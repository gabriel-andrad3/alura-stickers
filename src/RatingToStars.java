public class RatingToStars {
  public String transformRatingInStars(float rating) {
    var stars = "";
    var roundedRating = Math.round(rating);
    System.out.println(roundedRating);

    for (int i=0; i < roundedRating; i++) {
      stars += "\u2b50";
    }

    return stars;
  }
}
