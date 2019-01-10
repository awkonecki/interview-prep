# interview-prep
Interview prep coding challenges &amp; material.

## Setup
I have created a `Dockerfile` for those than want to work within the same environment.  This will require you to install docker onto you machine.

### Creating the Docker Image
To create the docker image you will need to run the build command as follows.  This currently is targeted for linux / OS X systems.

```bash
$ cd interview-prep
$ docker build . -t your-image
$ docker images
REPOSITORY                    TAG                 IMAGE ID            CREATED             SIZE
your-image                    latest              7fcf15d4335e        Just now            1.3 GB
```

### Running the Docker Image
I prefer to work in a clean environment for each launch so the following command is the command I use to run the environment.

```bash
$ docker run --rm -it -v /Users/awkonecki/awkonecki-ws/:/awkonecki-ws/ your-image
```

There are a few commands that I will explain.
- `--rm` informs docker to remove the container once you exit the container/container closes.  Any changes will be lost.
- `-it` this is the option to support interactive tty mode which is reponsible for routing the container output to the terminal through standard IO pipes.
- `-v` informs the container to mount the designated folder/directory into the specific location within the container.  The first path is the absolute path to the folder I want to mount on my machine.  After the `:` is the destination directory where my folder will exist.
