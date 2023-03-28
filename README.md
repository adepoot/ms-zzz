# ms-zzz

This is the backend of [the Flutter app](https://adepoot.github.io/app_zzz/#/) I wrote for my futsal club 'De Zwarte Zeverzwijnen'.

This repo contains both the API and all data from our matches.

## Deployment to Google App Engine

The API can easily be deployed to GAE with the following command:

```
gcloud app deploy
```

This command uses the [appengine/app.yaml](src/appengine/app.yaml) file to configure the app on GAE.

> NOTE: make sure to be correctly authenticated with `gcloud`
