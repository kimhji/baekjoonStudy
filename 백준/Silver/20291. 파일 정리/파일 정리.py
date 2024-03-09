import sys
filesN = int(sys.stdin.readline())
fileFormSet = set()
fileDic = {}
for inputC in range(filesN):
    fileName = sys.stdin.readline().split('.')
    form = fileName[1].rstrip()
    if form in fileFormSet:
        num = fileDic[form]
        fileDic[form] = num + 1
    else:
        fileFormSet.add(form)
        fileDic[form] = 1
sortFileList = []
for sortFiles in fileFormSet:
    sortFileList.append((sortFiles, fileDic[sortFiles]))
sortFileList.sort()
for printC in sortFileList:
    print(printC[0], printC[1])