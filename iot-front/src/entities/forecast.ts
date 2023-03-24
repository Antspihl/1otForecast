interface ForecastPlace {
  name: string;
  phenomenon: string;
  tempMin?: string;
  tempMax?: string;
}

interface ForecastPeriod {
  phenomenon: string;
  tempmin: string;
  tempmax: string;
  text: string;
  places: ForecastPlace[] | null;
}

interface ForecastPlace {
  name: string;
  phenomenon: string;
  tempMin?: string;
  tempMax?: string;
}

interface ForecastPeriod {
  phenomenon: string;
  tempMin: string;
  tempMax: string;
  text: string;
  places: ForecastPlace[] | null;
}

export interface Forecast {
  date: string;
  night: ForecastPeriod;
  day: ForecastPeriod;
}

