# Git merge exercise

The repository has two branches: `main` and `feature-branch`. Whenever new code gets merged into
`main` there is a CI/CD pipeline which deploys it to the production server. Your job, as a developer,
is to merge successfully `feature-branch` into `main` without conflicts and with all the tests passing
so the pipeline can deliver the latest version of the application to its customers.

In order to achieve it, make use of `git merge`. In case you run into any conflicts when merging,
choose the code in your feature branch and discard that of `main`.

## Helpful commands

For merge:

```
$ git merge <branch_to_merge>
$ git merge --continue
$ git merge --abort
$ git merge -h
```

The project is using Apache Maven for project management, so in order to compile, run the tests,
etc. pick the following commands:

```
$ mvn compile
$ mvn test
```
