<template>
  <v-app>
    <v-main>
      <Suspense>
        <Forecast :is="Forecast" />
      </Suspense>
    </v-main>
  </v-app>
</template>

<script setup lang="ts">
  import Forecast from "@/components/Forecast.vue";
</script>
