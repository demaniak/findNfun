# Introduction
I needed an excuse to play with Spring Shell.

So I found a little programming challenge online, that I then proceeded to solve
using Spring Shell in the mix.

Fun!

# Disclaimer
This is not going to be useful to pretty much anybody - sorry!

# Running
Once the (spring) shell is up, you can just type `find` to run with all defaults.

Run `help` or `help find` for more information.

# Unit tests
The default (generated) Spring unit tests hangs because the shell is opened and sits around waiting for input.

Not sure how to get around this yet, so I deleted the default test (which was just loading the spring context anyway - usefull
as a sanity check, but certainly not relevant for my goals).

