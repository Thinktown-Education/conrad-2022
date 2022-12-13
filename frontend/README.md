# Conrad 2022 Front End 

## Getting started

Before building the project, we need to set up `npm` for package management and building.\
Make sure you have `node` installed. Mac users are recommended to install node with brew.

Please make sure your node version is at least v19.
```
node.js version = 19.2.0
npm version = 8.19.3
```

Once it's installed, run this command in `frontend` directory.

### Dependencies
This command should install all the dependencies required to build the website
```
npm install
```
All of the dependencies will be automatically generated in `./node_modules/` directory.

### Build local
`npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

## Deployment
This section is for building the app to a web server.

### Build production
`npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

### Deploy Nginx using Docker
To maintain a clean environment, we're using Docker to deploy nginx. Make sure you have Docker installed. \
In `frontend` directory, run:
```
docker compose up -d
```

Now you should find your webiste live at [http://localhost](http://localhost)

### Troubleshooting

#### 1. Port conflict
The default server port is 80. Please make sure it's available or change port config in `docker-compose.yml` (Optional)

```yml
nginx:
    image: nginx:alpine
    container_name: conrad_nginx
    ports:
      - <Your desired port>:80
```


