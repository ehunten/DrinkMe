# DrinkMe

Open Git Bash in your 372 directory -  right click in explorer in that directory and click “Git Bash Here"

FIRST, clone the repository - git clone https://github.com/ehunten/DrinkMe.git

Switch to the branch you want to work on - git checkout -b branchname
(i. e. git checkout -b dom1 or git checkout -b hannah1)

Do your work in eclipse

Go back to git bash and: 
1. git add *
2. git commit -m "short descriptive message"
3. git push --set-upstream origin branchname

ALSO whenever you finish up working on your branch, before you commit and push, fetch the master!!!
git pull
git fetch

#Do this the first time you check your branch out, after cloning the repository. You'll know it worked if this readme file in your branch updates to match this one, which is on the master. 

This will get you up to date with the master so there's no conflicts when I go to merge the branchs.
If you have any questions just ask me
