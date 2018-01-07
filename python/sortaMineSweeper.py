from turtle import *
from os import *
from random import shuffle
from time import sleep

def drawSquare(xYPosition):
    showturtle()
    pu()
    goto(xYPosition)
    seth(0)
    pd()
    fillcolor("green")
    begin_fill()
    rt(45)
    circle(20, 360, 4)
    end_fill()
    pu()
    lt(45)
    hideturtle()

def drawEmpty(xYPosition):
    seth(0)
    speed(1)
    showturtle()
    pu()
    goto(xYPosition)
    pd()
    fillcolor("white")
    begin_fill()
    rt(45)
    circle(20, 360, 4)
    end_fill()
    pu()
    lt(45)
    hideturtle()

def drawMine(xYPosition):
    seth(0)
    speed(1)
    showturtle()
    pu()
    goto(xYPosition)
    pencolor("red")
    lt(45)
    pd()
    fd(40)
    pu()
    lt(135)
    fd(30)
    lt(135)
    pd()
    fd(40)
    hideturtle()
    pencolor("black")

def drawMinesNearby(xYPosition):
    seth(0)
    speed(1)
    showturtle()
    pu()
    goto(xYPosition)
    fillcolor("red")
    fd(25)
    lt(90)
    fd(15)
    pd()
    begin_fill()
    circle(10, 360)
    end_fill()
    pu()
    lt(45)
    hideturtle()

def coordList():
    coordList = [[[-200, 200], [-160, 200], [-120, 200], [-80, 200], [-40, 200]],
              [[-200, 160], [-160, 160], [-120, 160], [-80, 160], [-40, 160]],
              [[-200, 120], [-160, 120], [-120, 120], [-80, 120], [-40, 120]],
              [[-200, 80], [-160, 80], [-120, 80], [-80, 80], [-40, 80]],
              [[-200, 40], [-160, 40], [-120, 40], [-80, 40], [-40, 40]]]
    
    return coordList

def drawGameBoard():
    coList = coordList()
    speed(50)
    for i in range(5):
        drawSquare(coList[0][i])
        drawSquare(coList[1][i])
        drawSquare(coList[2][i])
        drawSquare(coList[3][i])
        drawSquare(coList[4][i])

def mineList():
    mineList = [[0, 0, 0, 0, 0, 0, 0],
                [0, 0, 0, 1, 0, 0, 0],
                [0, 0, 1, 0, 0, 0, 0],
                [0, 0, 0, 0, 1, 0, 0],
                [0, 0, 0, 0, 0, 1, 0],
                [0, 1, 0, 0, 0, 0, 0],
                [0, 0, 0, 0, 0, 0, 0]]
    
    return mineList

def shuffleMines():
    mines05 = mineList()

    sList = range(25)
    shuffle(sList)
    mines05[1][1:6] = sList[0:5]
    mines05[2][1:6] = sList[5:10]
    mines05[3][1:6] = sList[10:15]
    mines05[4][1:6] = sList[15:20]
    mines05[5][1:6] = sList[20:25]
    
    return mines05

def welcome():
    print "Welcome to Turtle SortaMineSweeper:"
    print "An 'empty box' means a miss and there are no mines nearby."
    print "A 'red circle' means a miss and there are mines nearby."
    print "Lastly, a 'red X' means you hit a land mine!"
    print
    sleep(5)

def mainMenu():
    print "1. Begin New Game"
    print "2. Show Score"
    print "3. Exit"
    option = input("Please select your option --> ")

    return option

def userName():
    print "Who would you like to play as?"
    print "1. Play as yourself"
    print "2. Play as anonymous"
    userInput = input("Select an option: ")

    while (userInput != 1 and userInput != 2):
        print "Invalid entry!"
        userInput = input("Select an option: ")
    
    if userInput == 1:
        nameID = 1
        userName = raw_input("Enter your name: ")
        
    if userInput == 2:
        nameID = 2
        userName = "Anonymous"

    return [nameID, userName]

def getCoordinates():
    print "Please input the coordinate"
    
    xCord = input("Row? ")
    while (xCord != 1 and xCord != 2 and xCord != 3 and xCord != 4\
           and xCord != 5):
        print "Invalid Entry!"
        xCord = input("Row? ")
    
    yCord = input("Col? ")
    while (yCord != 1 and yCord != 2 and yCord != 3 and yCord != 4\
           and yCord != 5):
        print "Invalid Entry!"
        yCord = input("Col? ")

    userCords = [xCord, yCord]

    return userCords

def userPickedLocation(x, y, mine):
    coList = coordList()

#Row 1 [-200, 200], [-160, 200], [-120, 200], [-80, 200], [-40, 200]
    if (x == 1 and y == 1):
        coordinate = coList[0][0]
        cordMine = [coordinate, mine[1][1]]
    elif (x == 1 and y == 2):
        coordinate = coList[0][1]
        cordMine = [coordinate, mine[1][2]]
    elif (x == 1 and y == 3):
        coordinate = coList[0][2]
        cordMine = [coordinate, mine[1][3]]
    elif (x == 1 and y == 4):
        coordinate = coList[0][3]
        cordMine = [coordinate, mine[1][4]]
    elif (x == 1 and y == 5):
        coordinate = coList[0][4]
        cordMine = [coordinate, mine[1][5]]

#Row 2 [-200, 160], [-160, 160], [-120, 160], [-80, 160], [-40, 160]
    elif (x == 2 and y == 1):
        coordinate = coList[1][0]
        cordMine = [coordinate, mine[2][1]]
    elif (x == 2 and y == 2):
        coordinate = coList[1][1]
        cordMine = [coordinate, mine[2][2]]
    elif (x == 2 and y == 3):
        coordinate = coList[1][2]
        cordMine = [coordinate, mine[2][3]]
    elif (x == 2 and y == 4):
        coordinate = coList[1][3]
        cordMine = [coordinate, mine[2][4]]
    elif (x == 2 and y == 5):
        coordinate = coList[1][4]
        cordMine = [coordinate, mine[2][5]]

#Row 3 [-200, 120], [-160, 120], [-120, 120], [-80, 120], [-40, 120]
    elif (x == 3 and y == 1):
        coordinate = coList[2][0]
        cordMine = [coordinate, mine[3][1]]
    elif (x == 3 and y == 2):
        coordinate = coList[2][1]
        cordMine = [coordinate, mine[3][2]]
    elif (x == 3 and y == 3):
        coordinate = coList[2][2]
        cordMine = [coordinate, mine[3][3]]
    elif (x == 3 and y == 4):
        coordinate = coList[2][3]
        cordMine = [coordinate, mine[3][4]]
    elif (x == 3 and y == 5):
        coordinate = coList[2][4]
        cordMine = [coordinate, mine[3][5]]

#Row 4 [-200, 80], [-160, 80], [-120, 80], [-80, 80], [-40, 80]
    elif (x == 4 and y == 1):
        coordinate = coList[3][0]
        cordMine = [coordinate, mine[4][1]]
    elif (x == 4 and y == 2):
        coordinate = coList[3][1]
        cordMine = [coordinate, mine[4][2]]
    elif (x == 4 and y == 3):
        coordinate = coList[3][2]
        cordMine = [coordinate, mine[4][3]]
    elif (x == 4 and y == 4):
        coordinate = coList[3][3]
        cordMine = [coordinate, mine[4][4]]
    elif (x == 4 and y == 5):
        coordinate = coList[3][4]
        cordMine = [coordinate, mine[4][5]]

#Row 5 [-200, 40], [-160, 40], [-120, 40], [-80, 40], [-40, 40]
    elif (x == 5 and y == 1):
        coordinate = coList[4][0]
        cordMine = [coordinate, mine[5][1]]
    elif (x == 5 and y == 2):
        coordinate = coList[4][1]
        cordMine = [coordinate, mine[5][2]]
    elif (x == 5 and y == 3):
        coordinate = coList[4][2]
        cordMine = [coordinate, mine[5][3]]
    elif (x == 5 and y == 4):
        coordinate = coList[4][3]
        cordMine = [coordinate, mine[5][4]]
    else:
        coordinate = coList[4][4]
        cordMine = [coordinate, mine[5][5]]

    return cordMine

def aroundOrClear(x, mine):
    coList = coordList()
    notMine = 0
    
#Row 1 Mines; x (coordinates) = [-200, 200], [-160, 200], [-120, 200], [-80, 200], [-40, 200]
    #(1,1)
    if x == coList[0][0]:
        if mine[0][0] == 0 and mine[0][1] == 0 and mine[0][2] == 0 and mine[1][0] == 0 and mine[1][2] > 5 and\
           mine[2][0] == 0 and mine[2][1] > 5 and mine[2][2] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(1,2)
    elif x == coList[0][1]:
        if mine[0][1] == 0 and mine[0][2] == 0 and mine[0][3] == 0 and mine[1][1] > 5 and mine[1][3] > 5 and\
           mine[2][1] > 5 and mine[2][2] > 5 and mine[2][3] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(1,3)
    elif x == coList[0][2]:
        if mine[0][2] == 0 and mine[0][3] == 0 and mine[0][4] == 0 and mine[1][2] > 5 and mine[1][4] > 5 and\
           mine[2][2] > 5 and mine[2][3] > 5 and mine[2][4] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(1,4)
    elif x == coList[0][3]:
        if mine[0][3] == 0 and mine[0][4] == 0 and mine[0][5] == 0 and mine[1][3] > 5 and mine[1][5] > 5 and\
           mine[2][3] > 5 and mine[2][4] > 5 and mine[2][5] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(1,5)
    elif x == coList[0][4]:
        if mine[0][4] == 0 and mine[0][5] == 0 and mine[0][6] == 0 and mine[1][4] > 5 and mine[1][6] == 0 and\
           mine[2][4] > 5 and mine[2][5] > 5 and mine[2][6] == 0:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
            
#Row 2 Mines; x (coordinates) =  [-200, 160], [-160, 160], [-120, 160], [-80, 160], [-40, 160]
    #(2,1)
    elif x == coList[1][0]:
        if mine[1][0] == 0 and mine[1][1] > 0 and mine[1][2] > 0 and mine[2][0] == 0 and mine[2][2] > 5 and\
           mine[3][0] == 0 and mine[3][1] > 5 and mine[3][2] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(2,2)
    elif x == coList[1][1]:
        if mine[1][1] > 5 and mine[1][2] > 5 and mine[1][3] > 5 and mine[2][1] > 5 and mine[2][3] > 5 and\
           mine[3][1] > 5 and mine[3][2] > 5 and mine[3][3] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(2,3)
    elif x == coList[1][2]:
        if mine[1][2] > 5 and mine[1][3] > 5 and mine[1][4] > 5 and mine[2][2] > 5 and mine[2][4] > 5 and\
           mine[3][2] > 5 and mine[3][3] > 5 and mine[3][4] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(2,4)
    elif x == coList[1][3]:
        if mine[1][3] > 5 and mine[1][4] > 5 and mine[1][5] > 5 and mine[2][3] > 5 and mine[2][5] > 5 and\
           mine[3][3] > 5 and mine[3][4] > 5 and mine[3][5] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(2,5)
    elif x == coList[1][4]:
        if mine[1][4] > 5 and mine[1][5] > 5 and mine[1][6] == 0 and mine[2][4] > 5 and mine[2][6] == 0 and\
           mine[3][4] > 5 and mine[3][5] > 5 and mine[3][6] == 0:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1

#Row 3 Mines; x (coordinates) = [-200, 120], [-160, 120], [-120, 120], [-80, 120], [-40, 120]
    #(3,1)
    elif x == coList[2][0]:
        if mine[2][0] == 0 and mine[2][1] > 5 and mine[2][2] > 5 and mine[3][0] == 0 and mine[3][2] > 5 and\
           mine[4][0] == 0 and mine[4][1] > 5 and mine[4][2] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(3,2)
    elif x == coList[2][1]:
        if mine[2][1] > 5 and mine[2][2] > 5 and mine[2][3] > 5 and mine[3][1] > 5 and mine[3][3] > 5 and\
           mine[4][1] > 5 and mine[4][2] > 5 and mine[4][3] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(3,3)
    elif x == coList[2][2]:
        if mine[2][2] > 5 and mine[2][3] > 5 and mine[2][4] > 5 and mine[3][2] > 5 and mine[3][4] > 5 and\
           mine[4][2] > 5 and mine[4][3] > 5 and mine[4][4] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(3,4)
    elif x == coList[2][3]:
        if mine[2][3] > 5 and mine[2][4] > 5 and mine[2][5] > 5 and mine[3][3] > 5 and mine[3][5] > 5 and\
           mine[4][3] > 5 and mine[4][4] > 5 and mine[4][5] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(3,5)
    elif x == coList[2][4]:
        if mine[2][4] > 5 and mine[2][5] > 5 and mine[2][6] == 0 and mine[3][4] > 5 and mine[3][6] == 0 and\
           mine[4][4] > 5 and mine[4][5] > 5 and mine[4][6] == 0:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1

#Row 4 Mines; x (coordinates) = [-200, 80], [-160, 80], [-120, 80], [-80, 80], [-40, 80]
    #(4,1)
    elif x == coList[3][0]:
        if mine[3][0] == 0 and mine[3][1] > 5 and mine[3][2] > 5 and mine[4][0] == 0 and mine[4][2] > 5 and\
           mine[5][0] == 0 and mine[5][1] > 5 and mine[5][2] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(4,2)
    elif x == coList[3][1]:
        if mine[3][1] > 5 and mine[3][2] > 5 and mine[3][3] > 5 and mine[4][1] > 5 and mine[4][3] > 5 and\
           mine[5][1] > 5 and mine[5][2] > 5 and mine[5][3] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(4,3)
    elif x == coList[3][2]:
        if mine[3][2] > 5 and mine[3][3] > 5 and mine[3][4] > 5 and mine[4][2] > 5 and mine[4][4] > 5 and\
           mine[5][2] > 5 and mine[5][3] > 5 and mine[5][4] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(4,4)
    elif x == coList[3][3]:
        if mine[3][3] > 5 and mine[3][4] > 5 and mine[3][5] > 5 and mine[4][3] > 5 and mine[4][5] > 5 and\
           mine[5][3] > 5 and mine[5][4] > 5 and mine[5][5] > 5:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(4,5)
    elif x == coList[3][4]:
        if mine[3][4] > 5 and mine[3][5] > 5 and mine[3][6] == 0 and mine[4][4] > 5 and mine[4][6] == 0 and\
           mine[5][4] > 5 and mine[5][5] > 5 and mine[5][6] == 0:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1

#Row 5 Mines x (coordinates) = [-200, 40], [-160, 40], [-120, 40], [-80, 40], [-40, 40]
    #(5,1)
    elif x == coList[4][0]:
        if mine[4][0] == 0 and mine[4][1] > 5 and mine[4][2] > 5 and mine[5][0] == 0 and mine[5][2] > 5 and\
           mine[6][0] == 0 and mine[6][1] == 0 and mine[6][2] == 0:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(5,2)
    elif x == coList[4][1]:
        if mine[4][1] > 5 and mine[4][2] > 5 and mine[4][3] > 5 and mine[5][1] > 5 and mine[5][3] > 5 and\
           mine[6][1] == 0 and mine[6][2] == 0 and mine[6][3] == 0:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(5,3)
    elif x == coList[4][2]:
        if mine[4][2] > 5 and mine[4][3] > 5 and mine[4][4] > 5 and mine[5][2] > 5 and mine[5][4] > 5 and\
           mine[6][2] == 0 and mine[6][3] == 0 and mine[6][4] == 0:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(5,4)
    elif x == coList[4][3]:
        if mine[4][3] > 5 and mine[4][4] > 5 and mine[4][5] > 5 and mine[5][3] > 5 and mine[5][5] > 5 and\
           mine[6][3] == 0 and mine[6][4] == 0 and mine[6][5] == 0:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1
    #(5,5)
    else:
        if mine[4][4] > 5 and mine[4][5] > 5 and mine[4][6] == 0 and mine[5][4] > 5 and mine[5][6] == 0 and\
           mine[6][4] == 0 and mine[6][5] == 0 and mine[6][6] == 0:
            drawEmpty(x)
            notMine += 1
        else:
            drawMinesNearby(x)
            notMine += 1

    return notMine

def winToLosses(nameNum, uSN, uWinCount, uLossCount, aWinCount, aLossCount):
    if nameNum == 1:
        if uLossCount == 0 and aLossCount == 0 and aWinCount == 0:
            print uSN + " win's = " + str(uWinCount) + " losses = 0."
            print
        elif aLossCount == 0 and aWinCount == 0:
            print uSN + " win's = " + str(uWinCount) + " losses = " + str(uLossCount)
            print
        elif aLossCount == 0:
            print uSN + " win's = " + str(uWinCount) + " losses = " + str(uLossCount)
            print
            print "Anonymous: " + " win's = " + str(aWinCount) + " losses = 0"
            print
        else:
            print uSN + " win's = " + str(uWinCount) + " losses = " + str(uLossCount)
            print
            print "Anonymous: " + " win's = " + str(aWinCount) + " losses = " + str(aLossCount)
            print
    elif nameNum == 2:
        if aLossCount == 0 and uLossCount == 0 and uWinCount == 0:
            print uSN + " win's = " + str(aWinCount) + " losses = 0."
            print
        elif uWinCount == 0 and uLossCount == 0:
            print uSN + " win's = " + str(aWinCount) + " losses = " + str(aLossCount) + "."
            print
        elif uWinCount == 0:
            print uSN + " win's = " + str(aWinCount) + " losses = " + str(aLossCount) + "."
            print
            print "Tom: " + " win's = 0" + " losses = 0."
            print
        else:
            print uSN + " win's = " + str(aWinCount) + " losses = " + str(aLossCount) + "."
            print
            print "Tom: " + " win's = 0" + " losses = 0."
            print
    else:
        print "You have not played yet, " + uSN + "!"
        print "Please play a game in order to create a record."
        print
    

def clearScreen():
    if name == "posix":
        system("clear")
    elif name == "nt":
        system("cls")
    else:
        print "***Unsupported System**\nApplication Terminating !!!"

def main():
    #Coordinate List
    coList = coordList()
    
    #Default variables
    nameID = 0
    userSelectedName = "anonymous gamer"
    anonymousLossCount = 0
    userLossCount = 0
    anonymousWinCount = 0
    userWinCount = 0
    
    #Welcome screen
    welcome()

    #Main menu
    option = 0
    while option != 3:
        option = mainMenu()
        
        #User wants to play a game
        if option == 1:
            
            #User picks if they want to be anonymous or themselves
            clearScreen()
            mineList = shuffleMines()
            name = userName()
            nameID = name[0]
            userSelectedName = name[1]

            #User wants to play as himself
            if nameID == 1:
                clearScreen()
                print mineList
                drawGameBoard()
                notMineCounter = 0
                gameOver = False
                while not gameOver:
                    inputCoords = getCoordinates()
                    clearScreen()
                    xCoord = inputCoords[0]
                    yCoord = inputCoords[1]
                    location = userPickedLocation(xCoord, yCoord, mineList)
                    coord = location[0]
                    mine = location[1]
                    if mine < 5:
                        drawMine(coord)
                        print "You loose!"
                        userLossCount += 1
                        gameOver = True
                        reset()
                    else:
                        notAMine = aroundOrClear(coord, mineList)
                        notMineCounter += notAMine
                        if notMineCounter == 20:
                            print "You win!"
                            userWinCount += 1
                            gameOver = True
                            reset()
                            
            #User wants to play as anonymous
            if nameID == 2:
                clearScreen()
                print mineList
                drawGameBoard()
                notMineCounter = 0
                gameOver = False
                while not gameOver:
                    inputCoords = getCoordinates()
                    clearScreen()
                    xCoord = inputCoords[0]
                    yCoord = inputCoords[1]
                    location = userPickedLocation(xCoord, yCoord, mineList)
                    coord = location[0]
                    mine = location[1]
                    if mine < 5:
                        drawMine(coord)
                        print "You loose!"
                        anonymousLossCount += 1
                        gameOver = True
                        reset()
                    else:
                        notAMine = aroundOrClear(coord, mineList)
                        notMineCounter += notAMine
                        if notMineCounter == 20:
                            print "You win!"
                            anonymousWinCount += 1
                            gameOver = True
                            reset()

        #User wants to see score
        elif option == 2:
            clearScreen()
            uWC = userWinCount
            uLC = userLossCount
            aWC = anonymousWinCount
            aLC = anonymousLossCount
            winToLosses(nameID, userSelectedName, uWC, uLC, aWC, aLC)

        #User wants to quit
        elif option == 3:
            clearScreen()
            print "Goodbye!"
            sleep(3)

        #User selection error
        else:
            print "Invalid option!"
            
main()
