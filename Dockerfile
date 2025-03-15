FROM ubuntu:latest
LABEL authors="justi"

ENTRYPOINT ["top", "-b"]