import os
cwd= os.getcwd()
print("Curret Directory is :",cwd)
os.chdir('../')
cwd= os.getcwd()
print("Current directory now:",cwd)
for i in range (1,10) :
    os.mkdir('Test-os-'+str(i))
path= 'G:\docker\Test-os-'
isDir = os.path.isdir(path) 
if (isDir==True):
    print('Path exists')
else:
    print('Path doesnt exists')
dir_list=os.listdir(cwd)
print("Current directory now:",dir_list)