FROM node:20-alpine
WORKDIR /app
COPY package*.json .
RUN npm i --silent
COPY . .
RUN echo "VITE_API_BASE_URI=http://localhost:8088" > .env
EXPOSE 5173
CMD ["npm", "run", "dev"]