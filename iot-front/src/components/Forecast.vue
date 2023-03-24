<template>
  <div>
    <v-toolbar :elevation="8" color=#12b26b>
      <v-toolbar-title>1ot proovitöö - Indrek Pihl</v-toolbar-title>
    </v-toolbar>
    <v-select
      v-if="forecastData"
      v-model="selectedDate"
      :items="forecastData.map(({date}) => date)"
      label="Vali kuupäev"
      outlined
      dense
    />
    <template v-if="selectedForecast">
      <v-col>
        <v-row>
          <v-col>
            <v-card>
              <div class="text-cyan">Night:</div>
              <div class="text-cyan">Temperature: {{ selectedForecast.night.tempmin }}°C -
                {{ selectedForecast.night.tempmax }}°C,
                {{ selectedForecast.night.phenomenon }}
              </div>
              <div class="text-cyan">{{ selectedForecast.night.text }}</div>
            </v-card>
          </v-col>
        </v-row>
        <v-row>
          <v-col
            v-for="place in selectedForecast.night.places"
          >
            <v-card>
              <div class="text-cyan">Place: {{ place.name }}</div>
              <div class="text-cyan">MinTemperature: {{ place.tempMin }}°C</div>
              <div class="text-cyan">{{ place.phenomenon }}</div>
            </v-card>
          </v-col>
        </v-row>
      </v-col>
      <v-col>
        <v-row>
          <v-col>
            <v-card>
              <div class="text-amber">Day:</div>
              <div class="text-amber">Temperature: {{ selectedForecast.day.tempmin }}°C - {{
                  selectedForecast.day.tempmax
                }}°C, {{ selectedForecast.day.phenomenon }}
              </div>
              <div class="text-amber">{{ selectedForecast.day.text }}</div>
            </v-card>
          </v-col>
        </v-row>
        <v-row>
          <v-col
            v-for="place in selectedForecast.day.places"
          >
            <v-card>
              <div class="text-amber">Place: {{ place.name }}</div>
              <div class="text-amber">MaxTemperature: {{ place.tempMax }}°C</div>
              <div class="text-amber">{{ place.phenomenon }}</div>
            </v-card>
            <v-spacer></v-spacer>
          </v-col>
        </v-row>
      </v-col>
    </template>
  </div>
</template>

<script setup lang="ts">
import {computed, onBeforeMount, ref} from "vue";
import axios from "axios";
import {Forecast} from "@/entities/forecast";

const forecastData = ref<Forecast[]>()
const selectedDate = ref('')
const selectedForecast = computed(() => forecastData.value?.find(({date}) => date === selectedDate.value))

onBeforeMount(async () => {
  const {data} = await axios.get<{ forecast: Forecast[] }>("http://localhost:8080/forecast");
  forecastData.value = data.forecast
  selectedDate.value = forecastData.value?.[0].date
})
</script>
