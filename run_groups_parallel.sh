#!/bin/bash

# 1. Old containers clearance
docker rm -f playwright-run-alerts_frame_windows playwright-run-interactions playwright-run-elements playwright-run-widgets 2>/dev/null

# 2. Group list
TEST_LIST="alerts_frame_windows interactions elements widgets"

for G in $TEST_LIST
do
  echo "----------------------------------------------------"
  echo "🚀 Starting container for group: $G"

  # MSYS_NO_PATHCONV=1 needed for work in Docker on Windows
  MSYS_NO_PATHCONV=1 docker run -d \
    --name "playwright-run-$G" \
    -v "/$(pwd):/app" \
    -w /app \
    mcr.microsoft.com/playwright/java:v1.58.0-noble \
    mvn test -Dgroups="$G" -Dplaywright.headless=true

  sleep 1
done

echo "----------------------------------------------------"
echo "✅ All containers started. Checking status..."
docker ps --filter "name=playwright-run"
