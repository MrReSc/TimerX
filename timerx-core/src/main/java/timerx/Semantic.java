package timerx;

import androidx.annotation.NonNull;

/**
 * Information about format, such as positions of different units, smallest available unit
 * and stripped version of format without escape symbols
 */
class Semantic {

  Position hoursPosition;
  Position minutesPosition;
  Position secondsPosition;
  Position rMillisPosition;
  TimeUnitType smallestAvailableUnit;

  String format;
  String strippedFormat;

  Semantic(@NonNull Position hoursPosition, @NonNull Position minutesPosition,
      @NonNull Position secondsPosition, @NonNull Position rMillisPosition,
      String format, String strippedFormat,
      TimeUnitType smallestAvailableUnit) {
    this.hoursPosition = hoursPosition;
    this.minutesPosition = minutesPosition;
    this.secondsPosition = secondsPosition;
    this.rMillisPosition = rMillisPosition;
    this.format = format;
    this.strippedFormat = strippedFormat;
    this.smallestAvailableUnit = smallestAvailableUnit;
  }

  @NonNull
  String getFormat() {
    return strippedFormat;
  }

  boolean has(@NonNull TimeUnitType unitType) {
    switch (unitType) {
      case HOURS:
        return hoursPosition.isNotEmpty();
      case MINUTES:
        return minutesPosition.isNotEmpty();
      case SECONDS:
        return secondsPosition.isNotEmpty();
      case R_MILLISECONDS:
        return rMillisPosition.isNotEmpty();
    }
    throw new IllegalArgumentException("Incorrect type of unit: " + unitType);
  }

  boolean hasOnlyRMillis() {
    return (rMillisPosition.isNotEmpty() && secondsPosition.isEmpty()
        && minutesPosition.isEmpty() && hoursPosition.isEmpty());
  }
}