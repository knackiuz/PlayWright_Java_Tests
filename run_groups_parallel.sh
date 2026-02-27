#!/bin/bash

# Очистка
docker rm -f playwright-run-alerts_frame_windows playwright-run-interactions playwright-run-elements playwright-run-widgets 2>/dev/null

GROUPS=("alerts_frame_windows" "interactions" "elements" "widgets")

for G in "${GROUPS[@]}"
do
  echo "Starting container for group: $G..."

  MSYS_NO_PATHCONV=1 docker run -d \
    --name "playwright-run-$G" \
    -v "/$(pwd):/app" \
    -w /app \
    mcr.microsoft.com/playwright/java:v1.58.0-noble \
    mvn test -Dgroups="$G" -Dplaywright.headless=true &

  sleep 2
done

echo "All commands sent to Docker. Checking status..."
docker ps