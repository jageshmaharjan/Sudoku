/**
 * Created by jagesh on 12/05/2015.
 */

//So far I've made this game calculation for single player game, Need to adjust fro multiplayer game
public class GameCalculation
{
    public boolean validMoves(int[][] board,Object data,int row,int col)
    {
        boolean isvalid = true;
        Object value = data;
        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                if (row == i && col == j)
                {
                    board[row][col] = Integer.parseInt((String) data) ;
                }
            }
        }
        if (rowcolcheck(board,row,col) && checkInBlock(board,row,col))
        {
            isvalid = true;
        }
        else
            isvalid = false;

        return isvalid;
    }

    public boolean checkInBlock(int[][] board,int row,int col)
    {
        boolean isBlockOk = true;
        int k=0;
        int[] dataValue = new int[9];
        if(row < 3 && col <3)
        {
            for (int i=0;i<3;i++)
            {
                for (int j=0;j<3;j++)
                {
                    dataValue[k] = board[i][j];
//                    System.out.println("I am at one" + row + col);
                    //System.out.println(dataValue[k]);
                    k++;
                }
            }
        }
        else if (row>2 && row<6 && col<3)
        {
            for (int i=3;i<6;i++)
            {
                for (int j=0;j<3;j++)
                {
                    dataValue[k] = board[i][j];
//                    System.out.println("I am at Two" + row + col);
                    //System.out.println(dataValue[k]);
                    k++;
                }
            }
        }
        else if(row >5 && row<9 && col<3)
        {
            for (int i=6;i<9;i++)
            {
                for (int j=0;j<3;j++)
                {
                    dataValue[k] = board[i][j];
//                    System.out.println("I am at Three" + row + col);
                    //System.out.println(dataValue[k]);
                    k++;
                }
            }
        }
        else if (row < 3 && col>2 && col<6)
        {
            for (int i=0;i<3;i++)
            {
                for (int j=3;j<6;j++)
                {
                    dataValue[k] = board[i][j];
//                    System.out.println("I am at Four" + row + col);
                    //System.out.println(dataValue[k]);
                    k++;
                }
            }
        }
        else if (row>2 && row<6 && col>2 && col<6)
        {
            for (int i=3;i<6;i++)
            {
                for (int j=3;j<6;j++)
                {
                    dataValue[k] = board[i][j];
//                    System.out.println("I am at Five" + row + col);
                    //System.out.println(dataValue[k]);
                    k++;
                }
            }
        }
        else if (row>5 && row<9 && col>2 && col<6)
        {
            for (int i=6;i<9;i++)
            {
                for (int j=3;j<6;j++)
                {
                    dataValue[k] = board[i][j];
//                    System.out.println("I am at Six" + row + col);
                    //System.out.println(dataValue[k]);
                    k++;
                }
            }
        }
        else if (row<3 && col>5 && col<9)
        {
            for (int i=3;i<6;i++)
            {
                for (int j=6;j<9;j++)
                {
                    dataValue[k] = board[i][j];
//                    System.out.println("I am at Seven" + row + col);
                    //System.out.println(dataValue[k]);
                    k++;
                }
            }
        }
        else if (row>2 && row<6 && col>5 && col<9)
        {
            for (int i=3;i<6;i++)
            {
                for (int j=6;j<9;j++)
                {
                    dataValue[k] = board[i][j];
//                    System.out.println("I am at Eight" + row + col);
                    //System.out.println(dataValue[k]);
                    k++;
                }
            }
        }
        else if (row>5 && row<9 && col>5 && col<9)
        {
            for (int i=6;i<9;i++)
            {
                for (int j=6;j<9;j++)
                {
                    dataValue[k] = board[i][j];
//                    System.out.println("I am at Nine" + row + col);
                    //System.out.println(dataValue[k]);
                    k++;
                }
            }
        }
        //---Check if block has duplicate values
        for (int i =0;i<9;i++)
        {
            for (int j=0;j<i;j++)
            {
                if (dataValue[i] == dataValue[j] && (dataValue[i] != 0) && (dataValue[j] != 0))
                {
                    //System.out.println("Duplicate in a block: " + dataValue[i]);
                    isBlockOk = false;
                }
            }
        }
        return isBlockOk;
    }

    public boolean rowcolcheck(int[][] board,int row,int col)
    {
        boolean isRowColOk =true;
        int[] rowVal = new int[9];
        int[] colVal = new int[9];
        //store a row data in one array and column data in another data
        for (int i=0;i<9;i++)
        {
            rowVal[i] = board[row][i];
            colVal[i] = board[i][col];
        }
        //check for Duplication
        for (int i=0;i<9;i++)
        {
            for (int j=0;j<i;j++)
            {
                if (rowVal[i] == rowVal[j])
                {
                    isRowColOk = false;
//                    System.out.println("Row Duplicate found with " + rowVal[i]);
                    break;
                }
                else if (colVal[i] == colVal[j])
                {
                    isRowColOk = false;
//                    System.out.println("Col Duplicate found with " + colVal[i] );
                    break;
                }
            }
        }
        return isRowColOk;
    }

    public void overallGameCheck(int[][] board)
    {
        int[] allValue = new int[81];
        int k = 0;
        for (int i=0;i<9;i++)
        {
            for (int j=0;j<9;j++)
            {
                if(board[i][j] == board[i][j+1] )
                allValue[k] = board[i][j];
                k++;
            }
        }
    }
}
