T=44100;
t=1:1:T;
y(t) = 5 * sin(2*pi*t);
plot(y);
%player = audioplayer (y, 44100, 8);
%play (player);