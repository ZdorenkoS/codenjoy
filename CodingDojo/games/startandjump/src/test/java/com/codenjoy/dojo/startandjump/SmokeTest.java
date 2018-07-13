package com.codenjoy.dojo.startandjump;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2016 - 2018 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.codenjoy.dojo.client.LocalGameRunner;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.startandjump.client.Board;
import com.codenjoy.dojo.startandjump.client.ai.VladKvadratSolver;
import com.codenjoy.dojo.startandjump.services.GameRunner;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SmokeTest {

    @Test
    public void test() {
        // given
        List<String> messages = new LinkedList<>();

        LocalGameRunner.timeout = 0;
        LocalGameRunner.out = (e) -> messages.add(e);
        LocalGameRunner.countIterations = 10;

        Dice dice = LocalGameRunner.getDice(
                0, 2, 4, 1, 2, // random numbers
                0, 3, 5, 6, 6,
                0, 4, 6, 1, 3,
                0, 4, 7, 6, 6,
                0, 4, 5, 6, 3,
                2, 1, 4, 0, 2,
                3, 5, 4, 6, 1,
                2, 1, 5, 3, 2,
                0, 1, 3, 2, 1);

        GameRunner gameType = new GameRunner() {
            @Override
            protected Dice getDice() {
                return dice;
            }

            @Override
            protected String getMap() {
                return "#########" +
                        " =       " +
                        " =       " +
                        " =       " +
                        "         " +
                        "☺       =" +
                        " =    == " +
                        " =  ==   " +
                        "#########";
            }
        };

        // when
        LocalGameRunner.run(gameType,
                new VladKvadratSolver(dice),
                new Board());

        // then
        assertEquals("1:Board:\n" +
                        "1:#########\n" +
                        "1: =       \n" +
                        "1: =       \n" +
                        "1: =       \n" +
                        "1:         \n" +
                        "1:☺       =\n" +
                        "1: =    == \n" +
                        "1: =  ==   \n" +
                        "1:#########\n" +
                        "1:\n" +
                        "1:Answer: UP\n" +
                        "DICE:0\n" +
                        "DICE:2\n" +
                        "Fire Event: STILL_ALIVE\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:#########\n" +
                        "1:=        \n" +
                        "1:=        \n" +
                        "1:=        \n" +
                        "1:☺        \n" +
                        "1:       = \n" +
                        "1:=    ==  \n" +
                        "1:=  ==   =\n" +
                        "1:#########\n" +
                        "1:\n" +
                        "1:Answer: UP\n" +
                        "Fire Event: STILL_ALIVE\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:#########\n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:☺        \n" +
                        "1:         \n" +
                        "1:      =  \n" +
                        "1:    ==   \n" +
                        "1:  ==   ==\n" +
                        "1:#########\n" +
                        "1:\n" +
                        "1:Answer: UP\n" +
                        "DICE:4\n" +
                        "DICE:1\n" +
                        "DICE:2\n" +
                        "Fire Event: STILL_ALIVE\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:#########\n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:☺        \n" +
                        "1:     =   \n" +
                        "1:   ==    \n" +
                        "1: ==   == \n" +
                        "1:#########\n" +
                        "1:\n" +
                        "1:Answer: UP\n" +
                        "DICE:0\n" +
                        "DICE:3\n" +
                        "Fire Event: STILL_ALIVE\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:#########\n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:☺   =    \n" +
                        "1:  ==     \n" +
                        "1:==   == =\n" +
                        "1:#########\n" +
                        "1:\n" +
                        "1:Answer: UP\n" +
                        "Fire Event: STILL_ALIVE\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:#########\n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:☺  =     \n" +
                        "1: ==      \n" +
                        "1:=   == ==\n" +
                        "1:#########\n" +
                        "1:\n" +
                        "1:Answer: UP\n" +
                        "Fire Event: STILL_ALIVE\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:#########\n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:☺        \n" +
                        "1:  =      \n" +
                        "1:==       \n" +
                        "1:   == ===\n" +
                        "1:#########\n" +
                        "1:\n" +
                        "1:Answer: UP\n" +
                        "DICE:5\n" +
                        "DICE:6\n" +
                        "DICE:6\n" +
                        "Fire Event: STILL_ALIVE\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:#########\n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:☺        \n" +
                        "1:         \n" +
                        "1: =       \n" +
                        "1:=        \n" +
                        "1:  == === \n" +
                        "1:#########\n" +
                        "1:\n" +
                        "1:Answer: UP\n" +
                        "DICE:0\n" +
                        "DICE:4\n" +
                        "DICE_CORRECTED < 4 :0\n" +
                        "Fire Event: STILL_ALIVE\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:#########\n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:☺        \n" +
                        "1:=        \n" +
                        "1:         \n" +
                        "1: == ===  \n" +
                        "1:#########\n" +
                        "1:\n" +
                        "1:Answer: UP\n" +
                        "DICE:6\n" +
                        "DICE_CORRECTED < 6 :0\n" +
                        "DICE:1\n" +
                        "Fire Event: STILL_ALIVE\n" +
                        "------------------------------------------\n" +
                        "1:Board:\n" +
                        "1:#########\n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:☺        \n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:         \n" +
                        "1:== ===  =\n" +
                        "1:#########\n" +
                        "1:\n" +
                        "1:Answer: UP\n" +
                        "DICE:3\n" +
                        "DICE:0\n" +
                        "DICE:4\n" +
                        "Fire Event: STILL_ALIVE\n" +
                        "------------------------------------------",
                String.join("\n", messages));

    }
}
