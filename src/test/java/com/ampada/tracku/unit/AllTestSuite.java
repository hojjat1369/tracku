package com.ampada.tracku.unit;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ampada.tracku.unit.board.CreateBoardTest;
import com.ampada.tracku.unit.board.DeleteBoardTest;
import com.ampada.tracku.unit.board.UpdateBoardTest;
import com.ampada.tracku.unit.card.CreateCardTest;
import com.ampada.tracku.unit.card.DeleteCardTest;
import com.ampada.tracku.unit.card.UpdateCardTest;
import com.ampada.tracku.unit.user.AuthenticateUserTest;
import com.ampada.tracku.unit.user.CreateUserTest;


@RunWith(Suite.class)
@SuiteClasses({

				CreateUserTest.class

				, AuthenticateUserTest.class

				, CreateBoardTest.class

				, UpdateBoardTest.class

				, DeleteBoardTest.class

				, CreateCardTest.class

				, UpdateCardTest.class

				, DeleteCardTest.class

})
public class AllTestSuite {

}
