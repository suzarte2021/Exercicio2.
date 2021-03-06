package br.com.mariojp.exercise2;

import android.content.pm.ActivityInfo;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.action.ViewActions.*;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;



/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4ClassRunner.class)
public class CorrecaoTest {

    @Rule
    public ActivityScenarioRule<br.com.mariojp.exercise2.MainActivity> activityScenarioRule = new ActivityScenarioRule<>(
            br.com.mariojp.exercise2.MainActivity.class);



    @Test
    public void checaValoresIniciaisDaPrimeiraTela() {
        onView(withId(R.id.textView))
                .check(matches(withText("Oi!")));
        onView(withId(R.id.btnTrocar))
                .check(matches(withText("Trocar usuário")));
    }

    @Test
    public void checaValoresIniciaisDaSegundaTela() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .check(matches(withText("")));


        onView(withId(R.id.btnTrocar))
                .check(matches(withText("Confirmar")));

        onView(withId(R.id.btnCancelar))
                .check(matches(withText("Cancelar")));
    }

    @Test
    public void checaMensagemAoTrocarNome() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(typeText("Sicrano"));

        onView(withId(R.id.editText)).perform(ViewActions.closeSoftKeyboard());


        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(withText("Oi, Sicrano!")));
    }

    @Test
    public void checaSeMensagemNaoMudaAoCancelarATrocaDeNome() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(typeText("Sicrano"));

        onView(withId(R.id.btnCancelar))
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(withText("Oi!")));
    }

    @Test
    public void checaSeMensagemNaoMudaAoCancelarATrocaDeNomePeloBotaoBack() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(typeText("Sicrano"));

        onView(withId(R.id.editText)).perform(ViewActions.closeSoftKeyboard());


        Espresso.pressBack();

        onView(withId(R.id.textView))
                .check(matches(withText("Oi!")));
    }

    @Test
    public void checaSeCaixaDeTextoMostraUsuarioAtual() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(typeText("Beltrano"));

        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .check(matches(withText("Beltrano")));
    }

    @Test
    public void checaSeStringVaziaResultaEmNaoTerUsuarioAtual() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(typeText("Beltrano"));

        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(clearText());

        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.textView))
                .check(matches(withText("Oi!")));
    }

    @Test
    public void checaSeMensagemSeMantemAposRotacao() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(typeText("Beltrano"));

        onView(withId(R.id.editText)).perform(ViewActions.closeSoftKeyboard());


        onView(withId(R.id.btnTrocar))
                .perform(click());

        activityScenarioRule.getScenario().onActivity(activity -> {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        });

        onView(withId(R.id.textView))
                .check(matches(withText("Oi, Beltrano!")));
    }

    @Test
    public void checaSeUsuarioAtualSeMantemAposRotacao() {
        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .perform(typeText("Beltrano"));

        onView(withId(R.id.editText)).perform(ViewActions.closeSoftKeyboard());


        onView(withId(R.id.btnTrocar))
                .perform(click());

        activityScenarioRule.getScenario().onActivity(activity -> {
            activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        });

        onView(withId(R.id.btnTrocar))
                .perform(click());

        onView(withId(R.id.editText))
                .check(matches(withText("Beltrano")));
    }


}
