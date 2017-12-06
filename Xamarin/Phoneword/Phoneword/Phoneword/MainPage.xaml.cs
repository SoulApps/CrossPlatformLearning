using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;

namespace Phoneword
{
    public partial class MainPage : ContentPage
    {

        private string translatedNumber;

        public MainPage()
        {
            InitializeComponent();
        }

        private void Translate(object sender, EventArgs e)
        {
            translatedNumber = PhonewordTranslator.ToNumber(phoneNumberText.Text);
            if (!string.IsNullOrEmpty(translatedNumber))
            {
                callButton.Text = "Call " + translatedNumber;
                callButton.IsEnabled = true;
            }
            else
            {
                callButton.Text = "Call";
                callButton.IsEnabled = false;
            }
        }

        private async void Call(object sender, EventArgs e)
        {
            if (await DisplayAlert("Dial a Number", String.Format("Would you like to call {0}?", translatedNumber), "Yes", "No"))
            {
                var dialer = DependencyService.Get<IDialer>();
                if (dialer != null)
                    dialer.Dial(translatedNumber);
            }
        }
    }
}