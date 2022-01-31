#1
# x = [ [5,2,3], [10,8,9] ] 
# students = [
#     {'first_name':  'Michael', 'last_name' : 'Jordan'},
#     {'first_name' : 'John', 'last_name' : 'Rosales'}
# ]
# sports_directory = {
#     'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
#     'soccer' : ['Messi', 'Ronaldo', 'Rooney']
# }
# z = [ {'x': 10, 'y': 20} ]

# x[1][0]=15
# print(x)
# students[0]["last_name"]="bryant"
# print(students)
# sports_directory["soccer"][0]="andres"
# print(sports_directory)
# z[0]["y"]=30
# print(z)

#2
students = [
        {'first_name':  'Michael', 'last_name' : 'Jordan'},
        {'first_name' : 'John', 'last_name' : 'Rosales'},
        {'first_name' : 'Mark', 'last_name' : 'Guillen'},
        {'first_name' : 'KB', 'last_name' : 'Tonel'}
    ]
# def iterateDictionary(students):
#     for i in range(0,len(students),1):
#         print("first_name",students[i]["first_name"],",last_name",students[i]["last_name"])

# print(iterateDictionary(students))

# #3
# def iterateDictionary2(key_name,some_list):
#     for x in range (len(some_list)):
#         print (some_list[x][key_name])

# iterateDictionary2("first_name",students)


#4
dojo = {
    'locations': ['San Jose', 'Seattle', 'Dallas', 'Chicago', 'Tulsa', 'DC', 'Burbank'],
    'instructors': ['Michael', 'Amy', 'Eduardo', 'Josh', 'Graham', 'Patrick', 'Minh', 'Devon']
}
def printInfo(some_dict):
    count=0
    for x in (some_dict):
        print(some_dict[x],x)
        count=0
        for value in some_dict[x] :
            count+=1
        print(count)
printInfo(dojo)








